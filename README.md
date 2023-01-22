# Lecture Notes

Lecture Notes for the Spring 2023 semester.

## Table of Contents

I will periodically update this as the semester continues.

### [Lab Expectations](lab_expectations.md)

- Minimum Course Expectations

### [0. Useful Course Software](00_useful_course_software.md)

- BrightSpace
- Installing Java
- Git Bash
- Atom (or your favorite text editor)
- Github

### [1. Primitive Data Types](01_primitive_data_types.md)

- Java Primitives
  - `byte` / `short` / `int` / `long` / `float` / `double` / `boolean` / `char`
- common usage
- integer values can be initialized with different bases
    - decimal (base 10) / hexadecimal (base 16) / octal (base 8) / binary (base 2)
- improved readability for large numeric literals
    - e.g. long x = 10_000_100;
- Wrapper classes
    - `Byte` / `Short` / `Integer` / `Long` / `Float` / `Double` / `Boolean` / `Character`
    - each wrapper class has various methods to operate on the wrapped primitive type
    - wrappers are immutable
- Integer wrapper class's methods
    - Integer.parseInt(String)
    - Integer.valueOf(int)
    - Integer.valueOf(String)
    - toString()
    - intValue();
    - toHexString()
    - toOctalString()
    - toBinaryString()

### [2. Flow Control](02_flow_control.md)

- Conditional Statements
    - `if` / `else if` / `else`
    - `switch` / `case` / `default`
- Loop Statements
    - `for` loop / `while` loop / `do-while` loop
- Branch Statements
    - `break`
    -`continue`
    - `return`
    - `break` utilizing a label attached to a loop
    - `continue` utilizing a label attached to a loop
    
### [3. Arrays of primitive types](03_arrays_of_primitive_types.md)

- Array Definition
- Indexing into an array
- Array Declaration and initialization
- Default Values
- Array Allocation
- Multi-Dimensional Arrays
- Jagged Arrays
- Other primitive type arrays

### [4. Strings](04_strings.md)

- What is a Class?
- Bicycle class example
- Java `String` class
- Class vs. Objects / Instances
- Constructors
- Methods
- Method overloading
- String concatenation
- `StringBuilder` and `StringBuffer`
- Strings are immutable

### [5. Reading Files](05_reading_files.md)

- Files Types 
	- Binary vs Text files
- The `File` class
	- `exists()` 
	- `getName()`
	- `getPath()`
	- `canRead()`
	- `canWrite()`
	- `createNewFile()`
	- `delete()`
	- `length()`
- File IO (Reading a text file)
	- The `BufferedReader` class
	- The `InputStreamReader` class
	- The `FileInputStream` class
	- importing classes from the `java.io` package
	- The `FileNotFoundException`
	- The `BufferedReader` `readLine()` method
	- `try-catch` block vs `try-with-resources` block
		- need to explictly `close()` in in a traditional `try-catch`
		- `try-with-resources` implicitly closes for us.
- Alternate approaches to read a text file: The `Scanner` class

- Parsing Text
	- `StringTokenizer`
		- `hasMoreTokens()`
		- `nextToken()`
		- `countTokens()`
	- `String` `split()` method
	- Example `ReadTextFileAndParseTokensExample.java`
