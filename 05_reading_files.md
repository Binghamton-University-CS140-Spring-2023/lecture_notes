-----------------------------
Reading files
-----------------------------

**Files Types**
- There are two types of files
  - Binary files
  - Non-binary files (text files)
  
**Binary Files**

- Typically, binary files can store the same amount of data more efficiently than a text file.
- They are important, because they can be read from and written to quicker than a text file.
- Some data can't easily be represented by characters.
	- For example, the btyecode in a Java class or the machine language of an executable file.
	- Image files that have may pixels are more efficiently written via binary
	- Computer games woud slow to a crawl if they didn't utilize binary
- Not human readable typically, but most binary files aren't meant to be read by humans.
	- There are specialized files that can use hex dumps, etc to help inspect these files on the rare occasion they need to be inspected.
	- In Java, there are classes which can help read in binary files while converting back to human readible characters in an efficient manner. (More to come below on this).

**Text Files**
- Human readible, but store data less efficently than binary files typically.

**The File Class**
- The File class is an abstract representation of a file (including the file path)
  - There are four constructors, one of which is
    - `File(String filename)` where `filename` can include a path as part of the filename
  - Take a look at the <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html" target="blank">online documentation</a>
  - There are plenty of methods for getting information about a File: </br>
`exists`, `getName`, `getPath`, `canRead`, `canWrite`, `createNewFile`, `delete`, `length`

# File IO (Reading a text file)

Let's start with something simple. We want to read lines from a text file. The following is one way to do it utilizing pre-existing Java classes.

**The BufferedReader Class**
  - We create a `BufferedReader` object based on the name of the file that we want to read from
     - Here `file` is an actual file in the computer file system versus a `File` object
  - A `BufferedReader` has two things that we want to use
     - It has a method to read a line of text – `readLine()`
     - And it buffers the input, so that reading from the file is efficient
  - The `BufferedReader` constructors requires a `Reader` argument
  - A `Reader` is an abstract class for reading from character streams
     - An abstract class is a class with the keyword abstract in its declaration. An abstract class cannot be instantiated. Classes can extend the abstract class, implementing any abstract methods.
  - Below is a couple of subclasses of `Reader`
     - `BufferedReader`
     - `CharArrayReader`
     - `FilterReader`
     - `InputStreamReader`
     - `PipedReader`
     - `StringReader`
 
 **The InputStreamReader Class**
  - We are going to use the `InputStreamReader`
     - An `InputStreamReader` can read bytes and convert them into characters
     - It has methods to read a single character or multiple characters into an char[]
     - The constructor requires an `InputStream`
  - An `InputStream` is an abstract class for representing an input stream of bytes
  - Below are some subclasses of `InputStream`
     - `AudioInputStream`
     - `ByteArrayInputStream`
     - `FileInputStream`
     - `FilterInputStream`
     - `ObjectInputStream`
     - `PipedInputStream`
     - `SequenceInputStream`
     - `StringBufferInputString`
  
  **The FileInputStream**
  - We will use the `FileInputStream`
  - A `FileInputStream` can read bytes from a file in a file system
  - There are constructors that take either a `File` or `String` to specify the file to read from
     - `FileInputStream(File file)`
     - `FileInputStream(String filename)`
  - `FileInputStream` has methods to
     - Read a single byte
     - Read multiple bytes into a byte array
     
 **Putting it All Together**
  - We now have everything that we need to instantiate our `BufferedReader`
  - Let `String` `filename` be the file that we want to read from
     - If the file is in the folder that you are executing your code from, then `filename` is just the name of the file
     - If the file is not in the folder that you are executing your code from, then `filename` needs to include enough path information for your program to find the file

  - We need to import these Java classes to leverage them.
  - To do so, we add the following at the top of our program:

```java  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;   
```

 - Then we construct a `BufferedReader` object to read `filename` as follows:

```java

BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
```

  - When writing code that involves reading a file, we need do so inside a try/catch block.
  	- What if the file doesn't exist?
  	- What if something goes wrong trying to read the contents of the file?
  	- Our program would crash in such cases without utilizng a try/catch block.
  	- If we give the program a filename that does not exist, the program will generate a `FileNotFoundException`
  	
  - With our `BufferedReader` object constructed, we can now use `input.readLine()` to read a line of text from the input file
  - `readLine()` returns `null` when the end of the file is reached.
  	- We leverage this fact to create our terminating condition of the while loop.

**Utilizing a try/catch block**
- Example (read the content of a file and output to `System.out`)
- Notice we need to close the `BufferedReader` object once we are done utilizing it.

```java
try {
  BufferedReader input = new BufferedReader(
      new InputStreamReader(new FileInputStream(args[0])));
  String inn;
  while((inn = input.readLine()) != null) {
    System.out.println(inn);
  }
  input.close();
} catch(Exception e) {
  System.out.println(e.toString());
  System.exit(1);
}
```

**Utilzing a try-with-resources block**
- Example (read the content of a file and output to `System.out`)
- Notice we do NOT need to explicitly close the `BufferedReader` object once we are done utilizing it.
- The try-with-resources block automatically closes the resource for us.

```java
try(BufferedReader input = new BufferedReader(
      new InputStreamReader(new FileInputStream(args[0])))) {
  String inn;
  while((inn = input.readLine()) != null) {
    System.out.println(inn);
  }
} catch(Exception e) {
  System.out.println(e.toString());
  System.exit(1);
}
```

**Alternative Approaches**
- We have looked at one way to read a text file, and there are other ways to do the equivalent
- We can also use the `Scanner` class to parse primitive types and Strings:
  - From a `File`
  - From an `InputStream`
  - From a `String`

# Parsing Text

Now that we can open up a text file, let's talk about how we can parse text and programmatically make sense of the data.

**The StringTokenizer Class**
- The `StringTokenizer` class can be used to break a `String` into individual tokens
- Example
    - `String testString = "abc xyz 012 lmn";`
    - Let's assume that the "tokens" or "data" are delimited by blank spaces, " ", in `testString`
     - We want to use the `StringTokenizer` class to break `testString` into the four tokens "abc", "xyz",  "012", and "lmn"
 - We can construct a `StringTokenizer` with the constructor `StringTokenizer(String stringInput)`, which defaults to using blank spaces, tabs ('\t'), newline ('\n'), carriage return ('\r'), and form feed character ('\f') as the delimiters
 - The `StringTokenizer` has methods to utilize:
    - `countTokens()`, how many tokens there are
    - `hasMoreTokens()`, if there are remaining tokens
    - `nextToken()`, return the next token

```java
String inn = new String("abc def ghi jkl");
java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
while(st.hasMoreTokens()){
  String token = st.nextToken();
  // statements to process the current token
}
```

- In the loop `token` will take the values "abc" the first time through the loop, "def" the second, "ghi" the third, and "jkl" the fourth.
- You could use `st.countTokens()` above to allocate a String array to contain the tokens of `testString`
- Alternatively we could use the `String.split()` method or a `Scanner` to split the line of text
   - We'll discuss `Scanner` in the future
- `String.split(String regularExpression)` will return an array of Strings delimitted by a *regularExpression* pattern
- Example, spliting on white space:

```java
String inn = new String("abc def ghi jkl");
String[] tokens = inn.split("\\s+");
System.out.println("tokens = " + Arrays.toString(tokens));
```

OUTPUT
```
tokens = [abc, def, ghi, jkl]
```

# Example program for Reading / Parsing a text file

The following resides in supplemenary examples: `ReadTextFileAndParseTokensExample.java`

- We want to
  - Create a `BufferedReader` for the first command-line argument
  - Read the lines of text from the buffered reader
  - For each line of text, parse out the tokens, delimitted by blank spaces
  - Print each line of text to the screen/console
  - Print each token of the current line of text, indent with a tab
  - Exit if there is no command-line argument
  - Catch any exceptions that might be generated while instantiating or processing the `BufferedReader`

**ReadTextFileAndParseTokensExample.java**

```java
import java.io.BufferedReader;       // importing the necessary classes
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class ReadTextFileAndParseTokensExample {
	public static void main(String[] args) {
		if(args.length != 1) {  // check the command line has a single argument
			System.out.println("format is: ReadTextFileAndParseTokensExample \"input file name\"");
			System.exit(0);
		}

		try	{
			BufferedReader input = new BufferedReader(
          new InputStreamReader(new FileInputStream(args[0])));
			String inn;
			while((inn = input.readLine()) != null) {    // read a line
				StringTokenizer st = new StringTokenizer(inn);  
				System.out.println(inn + " (" + st.countTokens() + ")"); // print it
				while(st.hasMoreTokens()) {    // go through the tokens in the line
					String s = st.nextToken();
					System.out.println("\t" + s);
				}
			}
			input.close();
		} catch(Exception e) {  // if any exceptions, write a message
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
```

- `sampleTextFile.txt`

```
horse cow pig sheep dog cat dolphin whale
frog salamander iguana
ant beetle grasshopper cricket millipede centipede
robin crow hawk eagle cowbird chicken turkey
salmon trout bass cod tuna haddock catfish


```

- Note: There are two empty lines at the end of the file

**OUTPUT**

```
> java ReadTextFileAndParseTokensExample sampleTextFile.txt
horse cow pig sheep dog cat dolphin whale (8)
	horse
	cow
	pig
	sheep
	dog
	cat
	dolphin
	whale
frog salamander iguana (3)
	frog
	salamander
	iguana
ant beetle grasshopper cricket millipede centipede (6)
	ant
	beetle
	grasshopper
	cricket
	millipede
	centipede
robin crow hawk eagle cowbird chicken turkey (7)
	robin
	crow
	hawk
	eagle
	cowbird
	chicken
	turkey
salmon trout bass cod tuna haddock catfish (7)
	salmon
	trout
	bass
	cod
	tuna
	haddock
	catfish
 (0)
 (0)
```

