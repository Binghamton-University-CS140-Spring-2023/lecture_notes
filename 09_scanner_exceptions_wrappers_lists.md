**Using Scanner**

- Using Scanner to parse input
  - Parse from a `File`
  - Parse from an `InputStream`
  - Parse a `String`
  - Parse from a `ReadableByteChannel`
     - Lookup up this in the Java documentation
- Can be used to parse numerous types of data
  - `boolean`, `byte`, `float`, `double`, `int`, `long`, `short`
- Can match based on a pattern
  - Example
     - `hasNext("[A-Za-z]+")`
- Supports parsing more data type than `StringTokenizer`, which only parses Strings
- To parse individual lines of a file (Prof Garrison's notes)
  - Create a `BufferedReader`
  - Read lines from the `BufferedReader`
      - For each line
      - Create a `Scanner` for the current line
          - `java.util.Scanner sc = new java.util.Scanner(inn);`
          - where `inn` is the String you want to parse

```java
while(sc.hasNext()) {
  String token = sc.next();
}
```

- To parse individual lines of a file an alternative that is simple but I have seen the Scanner fail to read completely to the end of a very large file

```java
// import Scanner, File. In a try/catch:
Scanner sc = new Scanner(new File(fileName));
while(sc.hasNextLine()) {
  String line = sc.nextLine();
  String[] tokens = line.split("\\s+");
}
```

**Exception Handling**

- Java will throw various exceptions while your program executes
- You can catch the exceptions and handle them in various ways
- Example
  - `Integer.parseInt(String v)` converts a `String` into an `int`, if the String v is not an int, it will throw a `NumberFormatException`
  - Your code can catch the exception and handle it:

```java
int intValue = -1;
try {
    Integer.parseInt(args[0]);
} catch(Exception NumberFormatException) {
  // code to do something if args[0] is not a String representation of an int
}
```

- There are three parts to exception handling
  - try block
      - Block to enclose the code that might cause an exception to be thrown
  - catch block
      - The exception handlers associated with a try block
      - You can have multiple catch blocks associated with a try block, to have your code handle different exceptions differently
      - For multiple catch blocks, the more specific exceptions need to come prior to the less specific
         - Exceptions are caught in the order they are listed, so an `ArrayIndexOutOfBoundsException` needs to precede an Exception, since the `Exception` will catch all exceptions, include the `ArrayIndexOutOfBoundsException`
      - If `Exception` precedes `ArrayIndexOutOfBoundsException`, the compiler will give an error stating that the `ArrayIndexOutOfBoundsException` has already been caught by the `Exception`
  - finally block
      - Block that executes after the try blocks exits, whether any exceptions were or were not thrown
  - Example

```Java
try {
    // code goes here
} catch(java.io.FileNotFoundException e)
    // exception handlers
} catch(NumberFormatException e)
    // exception handlers
} catch(ArrayIndexOutOfBoundsException e)
    // exception handlers
} catch(Exception e)
    // exception handlers
} finally {
    // executes after the try block exits
}
```

- Some methods require the exceptions to be caught or thrown. These exceptions that have to explicitly dealt with in the code are called "checked exceptions". Other exceptions are called "unchecked exception"
   - `java.io.BufferedReader.readLine()` can throw `IOException` which is a checked exception and your method must have a try catch for this exception or throw the exception if you call this method
- Some methods do not require exceptions to be caught or thrown when you use them
  - `Integer.parseInt()` can throw `NumberFormatException` but you are allowed to call the method without needing a try/catch or throw from the method. It is optional (and we did use it when reading ints) because itis unchecked.
  - There is more information in the <a href="https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html" target="blank">Java Tutorial</a> but some of the examples discuss things like zip file processing and database SQL commands, which are beyond the scope of this course.
- Sample code

```java
public class TryCatchFinallyTest {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("format: TryCatchFinallyTest \"input filename\" "
            + "\"array limit\" \"string tokenizer extra index\"");
			System.exit(1);
		}

		try	{
			System.out.println("in try block");

			int arrayUpperBound = -1;
			try	{
				System.out.println("in inner try block");
				arrayUpperBound = Integer.parseInt(args[1]);
			}	catch(NumberFormatException e) {
				System.out.println("in inner NumberFormatException");
				System.out.println(e.toString());
			}

			int stringTokenizerExtraIndex = Integer.parseInt(args[2]);
			int[] array = new int[10];

			for(int i = 0; i < arrayUpperBound; i++) {
				try {
					array[i] = i;
				} catch(Exception e) {
					System.out.println("in inner Exception");
					System.out.println(e.toString());
				}
			}

			for(int i = 0; i < arrayUpperBound; i++) {
				array[i] = i;
			}

			java.io.BufferedReader input = new java.io.BufferedReader(
          new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			String inn;
			while((inn = input.readLine()) != null) {
				java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
				int tokenCount = st.countTokens();
				for(int i = 0; i < (tokenCount+stringTokenizerExtraIndex); i++)	{
					String token = st.nextToken();
				}
			}
		}	catch(java.io.FileNotFoundException e) {
			System.out.println("in FileNotFoundException");
			System.out.println(e.toString());
		}	catch(NumberFormatException e) {
			System.out.println("in NumberFormatException");
			System.out.println(e.toString());
		}	catch(ArrayIndexOutOfBoundsException e)	{
			System.out.println("in ArrayIndexOutOfBoundsException");
			System.out.println(e.toString());
		}	catch(Exception e) {
			System.out.println("in Exception");
			System.out.println(e.toString());
		}	finally	{
			System.out.println("in finally block");
		}
	}
}
```

```java
public class TryCatchFinallyTest2 {
	public static void main(String[] args) throws java.io.IOException	{
		if(args.length != 1) {
			System.out.println("format: TryCatchFinallyTest2 \"input filename\"");
			System.exit(1);
		}

		java.io.BufferedReader input = new java.io.BufferedReader(
        new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
		String inn;
		while((inn = input.readLine()) != null) {
		}
	}
}
```

```java
public class ThrowTest {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("format: ThrowTest \"input value\" \"catch the error\"");
			System.exit(1);
		}

		boolean catchTheException = false;
		if(args[1].toLowerCase().startsWith("t"))	{
			catchTheException = true;
		}

		if(catchTheException)	{
			try	{
				methodThatThrows(args[0]);
			}	catch(Exception e) {
				System.out.println(e.toString());
				System.exit(1);
			}
		}	else {
			methodThatThrows(args[0]);
		}
	}

	private static void methodThatThrows(String stringToConvert)
        throws NumberFormatException	{
		byte[] numbers = new byte[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		byte[] bytes = stringToConvert.getBytes();
		boolean notANumber = false;
		for(int i = 0; (i < bytes.length) && (!notANumber); i++) {
			boolean found = false;
			for(int j = 0; (j < numbers.length) && (!found); j++) {
				if(bytes[i] == numbers[j]) found = true;
			}
			if(!found) notANumber = true;
		}
		if(notANumber) {
			throw new NumberFormatException("NumberFormatException in methodThatThrows");
		}
		int value = Integer.parseInt(stringToConvert);
	}
}
```

- There is also the try-with-resources statement
  - See <a href ="https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html" target="blank">Java Tutorials</a>. To quote:
  - "The try-with-resources statement is a try statement that declares one or more resources. <br/>A resource is an object that must be closed after the program is finished with it. The try-with-resources <br/>statement ensures that each resource is closed at the end of the statement. Any object that implements <br/>`java.lang.AutoCloseable`, which includes all objects which implement `java.io.Closeable`, can be used as a resource."
  - Pull up the Java documentation for AutoCloseable
  - For multiple resources use a semi-colon delimited list
  - Example:

```java
public class TryCatchWithResources {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("format: TryCatchWithResources \"input filename\" \"output filename\"");
			System.exit(1);
		}

		try
		(java.io.BufferedReader input = new java.io.BufferedReader(
        new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
		java.io.PrintWriter output = new java.io.PrintWriter(
        new java.io.BufferedWriter(new java.io.FileWriter(args[1])))) {
			String inn;
			while((inn = input.readLine()) != null)	{
				output.println(inn);
			}
		}	catch(Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
```

**Revisiting the Wrapper Classes**

- Wrapper classes give us a way to create an object version of each of the primitive types, so that we can use them with the various classes that only operate on objects
- As an example, the `ArrayList` can only be used with objects, so we cannot create an `ArrayList` that contains elements of type `int`, but we can create an `ArrayList` that contains `Integer`, where `Integer` is the wrapper class for `int`
- Note that arrays are objects, so we can create an `ArrayList` with each element being an `int` array of size 1, which is a way to simulate an `ArrayList` of ints. But it is not to be recommended
- The wrapper classes are
  - `Boolean`, `Double`, `Float`, `Integer`, `Long`, `Short`, `Byte`, `Character`
- Most of the constructors have been "deprecated", but they should all have a static method that creates the  applicable object, such as `Double d = Double.valueOf(double value);`
- The wrapper classes will auto “box” and “unbox” primitive types to/from the primitive types
  - See <a href="https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html" target="blank">Java tutorial on autoboxing and unboxing</a>
  - See `ArrayListAutoBoxing.java`

```java
import java.util.ArrayList;

// program to show autoboxing and unboxing for Integer class
// takes one command line paramter, the number of elements
// to put into an ArrayList<Integer>
class ArrayListAutoBoxing {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("format is: ArrayListAutoBoxing \"number of elements\"");
			System.exit(1);
		}
		// the the size of the ArrayList
		int numberOfValues = Integer.parseInt(args[0]);
		// instantiate the ArrayList to store the values
		ArrayList<Integer> intValues = new ArrayList<>();
		// add the values to intValues
		for(int i = 0; i < numberOfValues; i++)	{
			intValues.add(i);   // autobox
		}
		// enhanced loop over the values of intValues
		// compute the sum of the values in intValues
		long sum = 0;
		for(int v : intValues) { // autounbox
			sum = sum + v; // and coerce int->long
		}
		System.out.println("sum = " + sum);
		// for loop over the values of intValues
		// compute the sum of the values in intValues
		long sum2 = 0;
		for(int i = 0; i < intValues.size(); i++)	{
			sum2 = sum2 + intValues.get(i); // autounbox and coerce int->long
		}
		System.out.println("sum2 = " + sum2);
	}
}
```

- Example of ArrayList<Double>

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AboutArrayList {

	public static void main(String[] args) {
		args = new String[] {"15"};
		// ArrayList is part of a family of list types
		// It is the most common.
		// We like to declare our variables with the most general
		// type in the family in case we want to use the code again
		// with a different member of the family:
		List<Double> testList = new ArrayList<>();

		// Java does autoboxing of primitive types into their wrapper
		// as well as auto-unboxing

		Random rand = new Random(17);
		// the seed --here 17 is chosen-- means the program runs the
		// same each time
		for(int i = 0; i < Integer.parseInt(args[0]); i++)
			testList.add(rand.nextInt(100) + i/10.0);
		System.out.println(testList);
		Collections.sort(testList);		
		System.out.println(testList);
		Collections.shuffle(testList);		
		System.out.println(testList);
		testList.remove(0);
		testList.remove(4);
		testList.remove(3);
		testList.remove(3);
		System.out.println(testList);
		testList.add(2, 7.0);
		// testList.add(2, 7); does not compile
		System.out.println(testList);
		testList.add(2, Double.valueOf(6));
		System.out.println(testList);
		Double[] temp = {6.1, 7.4, 9.9};
		List<Double> tList = Arrays.asList(temp);
		testList.addAll(tList);
		System.out.println(testList);
	}
}
```
