---------------------------------------------
More on Reading and Writing Files
---------------------------------------------

- We saw how to read text files using a `FileReader` and `BufferedReader`

# Writing Text Files

- There are numerous different classes related to outputting data
- Here is one for “printing” text files:
	- `java.io.PrintWriter output = new java.io.PrintWriter(`<br/>&nbsp;&nbsp;&nbsp;
    `new java.io.BufferedWriter(new java.io.FileWriter(outputFileName)));`
    
**The `FileWriter` class** 
- writes text to character files
- Can construct with a `File` or `String` filename, with an optional characterset and append (versus overwrite)
- Has methods, `write()`, to write strings to a file
    	
**The `BufferedWriter` class**
- writes text to a character output stream, using a buffer to improve performance
- Constructor requires a `Writer`, such as `FileWriter`, and an optional buffer size
- There are also `Writers` for character arrays, output streams, and `Strings`
- Has methods, `write()`, to write strings to the `Writer`
	- Note that several commentators say that Java actually implements the `PrintWriter` with
a `BufferedWriter` in the code so you can just write:
	- `java.io.PrintWriter output = new java.io.FileWriter(outputFileName);`
	
**The `PrintWriter` class**	
- prints formatted representations of objects to text output streams
- Has various constructors for `File`, `OutputStream`, `Writer`, or `String` filename
- Has `print()`, `printf()`, and `println()` methods for `String` and the primitive types
- Has `format()` method to print using a format string

# Reading and writing data from a byte array

- Bytes to primitives: The byte data that we get from a binary file needs to be converted to the correct primitive type
- Primitives to bytes: The primitive types that we store in a binary file needs to be converted from primitive types to byte data

**The `ByteBuffer` class**

- We can use the `ByteBuffer` class to do the conversions
	- First, we wrap a `ByteBuffer` around a byte array 
	- Then, use the `ByteBuffer`'s methods to `get` primitive types *from* a byte array 
	- Or, `put` primitive types *into* a byte array
	
- There are `get` and `put` methods for all of the primitive types, except for `boolean`
	- IMPORTANT: We need to keep in mind the sizes of the primitive types when putting and getting values

**Creating a `ByteBuffer` via the `wrap()` method**

- To create a `ByteBuffer` we do the following:
  - First, create a byte array
    - `byte[] byteArray = new byte[20];`
  - Then, `wrap` a `ByteBuffer` around the byte array
    - `ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);`
    - `ByteBuffer` doesn't have a constructor
    - We use the static method `ByteBuffer.wrap(byte[] b)`, which returns a `ByteBuffer` object
    
**Leveraging the `ByteBuffer`: the `put()` and `get()` methods**

  - We now have a `ByteBuffer` that can read and write primitive types to the byte array that it is was *wrapped* around
    - `put` methods are used to *write* primitive types *into* the byte array
    	- `putFloat()`, `putLong()`, `putDouble()`, `putChar()` etc.
    - `get` methods are used to *read* primitive types *from* the byte array
    	- `getFloat()`, `getLong()`, `getDouble()`, `getChar()`, etc.
    - The `ByteBuffer` does all of the encoding and decoding of the values for us
    
    - The `ByteBuffer` writes the bits of the primitive type to the byte array, using the number of bytes associated with the primitive type's size
    - The values can be stored and reread and have the exact same value as the original primitive had
  - <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/ByteBuffer.html" target="blank">Java documentation for ByteBuffer</a>
  
# `ByteBuffer` Example Code

**Example High Level Summary**

- The following example does the following:
  - Creates a byte array
  - Creates a `ByteBuffer` wrapped around the byte array
  - Puts a `double` in the `ByteBuffer` at offset 0 (8 bytes)
  - Puts an `int` in the `ByteBuffer` at offset 8 (4 bytes)
  - Creates a second byte array and copies the content of the first byte array to the second byte array
  - Creates a second `ByteBuffer` wrapped around this second copied byte array
  - Gets a `double` from the second `ByteBuffer` at offset 0
  - Gets an `int` from the second `ByteBuffer` at offset 8
  - Outputs the `double` and `int` put into the original `ByteBuffer`
  - Output the `double` and `int` got out of the second `ByteBuffer`
  - We see that the `double` and `int` values match
  
**Example Relevance** 

- What the example is attempting to show is
  - We start with an byte array containing all 0s
  - We wrap a `ByteBuffer` around it, which allows us to write primitive types into the byte array via the `ByteBuffer`
  - We see that the byte array has been modified and that we can read the values we wrote into it back out
  - We then make a copy of the byte array – equivalent to storing as a binary file, and reading it later
  - We wrap a `ByteBuffer` around the copy of the byte array
  - We can read the two values stored in the original byte array via the `ByteBuffer`
  
**Working with a ByteBuffer - Accounting for Primitive Sizes**

- The `ByteBuffer` can keep track of where to write the next primitive type or you can
- Each `get` and `put` method has a version where you specify the starting location of the operation
- Each `get` an `put` method has a version where you don't specify the starting location of the operation
	- These increment the position based on the size of the primitive type
- The `position()` method can be used to set the index in the byte array that the `ByteBuffer` is using
- For my implementation of program 2, I used the `get` and `put` methods that specified the index to read/write from

```java
public class ByteBufferSampleCode {
	// program to store a double and an int in a byte array using a ByteBuffer
	// then read the values back and see that the values were properly
	// stored and retrieved
	// copy the byte array to a new byte array, and retrieve the double and int
	// that were stored in the original byte array and see that they are once
	// again retieved from a copy of the byte array (wants to simulate saving the
	// first byte array to a file, and then reading it into the second byte array)
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("format is: ByteBufferSampleCode \"double value\" \"int value\"");
			System.exit(0);
		}
		// allocate two byte arrays to hold the binary data
		// byteArray is the byte array that we store the values in
		// byteArrayB wants to simulate a byte array that we read the content of byteArray
		// into after storing it in a file
		byte[] byteArray = new byte[12];
		byte[] byteArrayB = new byte[12];

		// output the initial values of the byte array
		System.out.println("initial byteArray = ");
		for( int i = 0; i < byteArray.length; i++ ) {
			System.out.println("byteArray[" + i + "] = " + byteArray[i]);
		}
		System.out.println();

		// create a ByteBuffer that is wrapped around byteArray
		java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.wrap(byteArray);

		// convert the first commandline argument to a double
		double doubleValue = Double.parseDouble(args[0]);

		// convert the second commandline argument to an int
		int intValue = Integer.parseInt(args[1]);

		// print out the two values, this is mainly incase the double can't be represented correctly
		// and to compare to what we retrieve from the two byteArrays
		System.out.println("doubleValue = " + doubleValue);
		System.out.println("intValue = " + intValue);
		System.out.println();

		// store the double in byteArray starting at index 0 (uses bytes 0 - 7)
		// using the absolute put method
		byteBuffer.putDouble(0, doubleValue);

		// store the int in byteArray starting at index 8 (uses bytes 8 - 11)
		// using the absolute put method
		byteBuffer.putInt(8, intValue);

		// output the updated values of the byte array
		// we should see bytes 0 - 7 are completly different than they originally were
		// some of bytes 8 - 11 may still be 0, depending on how large of an int we entered
		System.out.println("filled in byteArray = ");
		for(int i = 0; i < byteArray.length; i++) {
			System.out.println("byteArray[" + i + "] = " + byteArray[i]);
		}
		System.out.println();

		// use the relative getDouble() to read the double value from byteArray 0 - 7
		double doubleValue2 = byteBuffer.position(0).getDouble();

		// use the absolute getDouble() to read the double value from byteArray 0 - 7
		double doubleValue3 = byteBuffer.getDouble(0);

		// use the relative getInt() to read the int value from byteArray 8 - 11
		int intValue2 = byteBuffer.position(8).getInt();

		// use the absolute getInt() to read the int value from byteArray 8 - 11
		int intValue3 = byteBuffer.getInt(8);

		System.out.println("the double and int values read back from byteArray");

		// print out the value read using relative getDouble()
		System.out.println("doubleValue2 = " + doubleValue2);

		// print out the value read using absolute getDouble()
		System.out.println("doubleValue3 = " + doubleValue3);

		// print out the value read using relative getInt()
		System.out.println("intValue2 = " + intValue2);

		// print out the value read using absolute getInt()
		System.out.println("intValue3 = " + intValue3);

		System.out.println();

		// copy byteArray into byteArrayB (simulates storing byteArray and
		// then reading it into byteArrayB
		for( int i = 0; i < byteArray.length; i++ ) {
			byteArrayB[i] = byteArray[i];
		}

		// create a ByteBuffer that is wrapped around byteArrayB
		java.nio.ByteBuffer byteBufferB = java.nio.ByteBuffer.wrap(byteArrayB);

		// use the relative and absolute versions of getDouble() to
		// get the double value from byteArrayB 0 - 7
		double doubleValue2B = byteBufferB.position(0).getDouble();
		double doubleValue3B = byteBufferB.getDouble(0);

		// use the relative and absolute versions of getInt() to
		// get the int value from byteArrayB 8 - 11
		int intValue2B = byteBufferB.position(8).getInt();
		int intValue3B = byteBufferB.getInt(8);

		System.out.println("the double and int values read from byteArrayB");

		// output the double values so that we see that they are the same
		System.out.println("doubleValue2B = " + doubleValue2B);
		System.out.println("doubleValue3B = " + doubleValue3B);

		// output the int values so that we see that they are the same
		System.out.println("intValue2B = " + intValue2B);
		System.out.println("intValue3B = " + intValue3B);
	}
}
```

**Quick Review on the ByteBuffer**
- The `ByteBuffer` can be used to convert bytes to primitive types and primitive types to bytes
- The `ByteBuffer` has methods to
  - Add primitive types to a `ByteBuffer`
    - `putChar()`, `putDouble()`, `putFloat()`, `putInt()`, `putLong()`, `putShort()`
  - Get primitive types from a `ByteBuffer`
    - `getChar()`, `getDouble()`, `getFloat()`, `getInt()`, `getLong()`, `getShort()`
  - The `get` and `put` methods either require an index to get/put the value or at the current location
  - There is no constructor for the `ByteBuffer`, but one way to create one is `ByteBuffer.wrap(byte[] byteArray)`, which will return a `ByteBuffer` *wrapped* around the byte array

**ByteBuffer example (writing)**  
- Wrap a `ByteBuffer` around a byte array and write some values into it
  - `byte[] buffer = new byte[20];`
  - `java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.wrap(buffer);`
  - `int intValue = 10;`
  - `double doubleValue =10.01;`
  - `char charValue = 'c';`
  - `byteBuffer.putInt(0, intValue); // 4 bytes for int`
  - `byteBuffer.putDouble(4, doubleValue); // 8 bytes for double`
  - `byteBuffer.putChar(12, charValue); // 2 bytes for char`
- The three values have been **encoded** as bytes in the byte[] buffer
- The first 14 bytes of buffer can now be written to a **binary file**

**ByteBuffer example (reading)**
- Wrap a `ByteBuffer` around a byte array that has been read from a binary file and read some values into it
	- `byte[] buffer = new byte[20];`
	- `java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.wrap(buffer);`
	- Read the first 14 bytes of a binary file into the byte array buffer in which the binary file contines an int, double, and char values
	- `int intValue = byteBuffer.getInt(0);`
	- `double doubleValue = byteBuffer.getDouble(4);`
	- `char charValue = byteBuffer.getChar(12);`
- The three values have been **decoded** from bytes in the byte[] buffer
- The three values can be used or written to a **text file**

# Using the ByteBuffer to read / write binary files

- Here is an example:
	- Utilizing `FileChannel` classes
		- `FileOutputStream`
		- `FileInputStream`
	- Note that when we read back in:
		- Utilizing a try-with-resources block
		- Utilizing the `allocate()` method of the `ByteBuffer` class
		- Utilizing the `rewind()` method of the `ByteBuffer` class, once we have called the `FileChannel` `read()` method

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferChannel {
	public static void main(String[] args) {
		byte[] buffer = new byte[20];
		ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
		int intValue = 10;
		double doubleValue =10.01;
		char charValue = 'c';
		byteBuffer.putInt(0, intValue); // 4 bytes for int
		byteBuffer.putDouble(4, doubleValue); // 8 bytes for double
		byteBuffer.putChar(12, charValue); // 2 bytes for char
		try (FileChannel wChannel =
				new FileOutputStream("buffertest.dat").getChannel())
		{
			wChannel.write(byteBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Now reading back in");

		try (FileInputStream fIn = new FileInputStream("buffertest.dat")) {			
			FileChannel fChan = fIn.getChannel();
			long fSize = fChan.size();
			ByteBuffer mBuf = ByteBuffer.allocate((int) fSize);
			fChan.read(mBuf);
			fChan.close();
			fIn.close();
			mBuf.rewind(); // go back to start
			int i1 = mBuf.getInt();
			double d1 = mBuf.getDouble();
			char c1 = mBuf.getChar();
			System.out.println(i1 + " " + d1 + " " + c1);
		} catch (IOException exc) {
			System.out.println(exc);
			System.exit(1);
		}
	}
}
```

# Data input and output streams

- In addition to reading and writing primitive types from/to a byte array, we can also do this with:

**The DataInputStream class**

- `DataInputStream` for reading values
    - Constructor requires an `InputStream`
    - `FileInputStream` works to read from a file
    - There is a constructor that takes a `String` filename
    - Has methods to read each primitive type, including `boolean`
    - Has a method to skip over bytes

**The DataOutputStream class**

- `DataOutputStream` for writing values
    - Constructor requires an `OutputStream`
    - `FileOutputStream` works to write to a file
    - There is a constructor that takes a `String` filename and optionally a `boolean` to append to an existing file
    - Has methods to write each primitive type, including `boolean`

**Java Documentation for Data Input / Output Streams**
- Documentation: <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataInputStream.html" target="blank">DataInputStream</a>, 
<a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/DataOutputStream.html" target="blank">DataOutputStream</a>

**Sample program**

  - Get a filename, a `double`, and an `int` as command-line parameters
  - Open a `DataOutputStream` and write the `double` and `int` to the `DataOutputStream`
  - Close the `DataOutputStream`
  - Open the same file as a `DataInputStream`
  - Read a `double` and an `int` from the `DataInputStream`
  - Output the values written and read to verify that everything worked

```java
class DataInputAndOutputStreamSampleCode {
	// program to write a double and int to a DataOutputStream and then read back
	// a double and an int from a DataInputStream
	public static void main(String[] args) {
		if( args.length != 3 ) {
			System.out.println("format is: DataInputAndOutputStreamSampleCode \"filename\" \"double value\" \"int value\"");
			System.exit(0);
		}

		// convert the first commandline argument to a double
		double doubleValueFromCommandLine = Double.parseDouble(args[1]);

		// convert the second commandline argument to an int
		int intValueFromCommandLine = Integer.parseInt(args[2]);

		try {
			// open the output file as a DataOutputStream stream
			java.io.DataOutputStream output = new java.io.DataOutputStream(new java.io.FileOutputStream(args[0]));

			// write the double
			output.writeDouble(doubleValueFromCommandLine);

			// write the int
			output.writeInt(intValueFromCommandLine);

			// close the file so everything is written to disk and so we can open it
			output.close();

			// open the output file as an input file as a DataInputStream
			// to read the two values that were just written to it
			java.io.DataInputStream input = new java.io.DataInputStream(new java.io.FileInputStream(args[0]));

			// read the double
			double doubleValueReadFromFile = input.readDouble();

			// read the int
			int intValueReadFromFile = input.readInt();

			// output the inputs from the commandline
			System.out.println("inputs from the commandline");
			System.out.println("doubleValueFromCommandLine = " + doubleValueFromCommandLine);
			System.out.println("intValueFromCommandLine = " + intValueFromCommandLine);
			System.out.println();

			// output the inputs from the file
			System.out.println("inputs from the file");
			System.out.println("doubleValueReadFromFile = " + doubleValueReadFromFile);
			System.out.println("intValueReadFromFile = " + intValueReadFromFile);
		} catch(Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}		
	}
}
```
