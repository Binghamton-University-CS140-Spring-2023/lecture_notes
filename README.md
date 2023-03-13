# Lecture Notes

Lecture Notes for the Fall 2022 semester.

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
  - `btye` / `short` / `int` / `long` / `float` / `double` / `boolean` / `char`
- common usage
- integer values can be initialized with different bases
    - decimal (base 10) / hexadecimal (base 16) / octal (base 8) / binary (base 2)
- improved readability for large numeric literals
    - e.g. long x = 10_000_100;
- Wrapper classes
    - `Btye` / `Short` / `Integer` / `Long` / `Float` / `Double` / `Boolean` / `Character`
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

### [6. Reading and Writing binary files](06_reading_and_writing_binary_files.md)

- Classes for reading
	- `FileInputStream`     : read bytes from a file
	- `BufferedInputStream` : adds a buffer to an input stream (for efficiency)

- Classes for writing
	- `FileOutputStream`    : write bytes to a file
		- can specify you want to ***append*** to  file via a boolean to the constructor
		- if you do not append, existing file will be overwritten
	- `BufferedOutputStream`: adds a buffer to an output stream (for efficiency)

### [7. More on Reading and Writing Files](07_more_on_reading_and_writing_files.md)

- Writing Text Files
	- `FileWriter`
	- `BufferedWriter`
	- `PrintWriter`
- Reading and Writing data from a byte array
	- `ByteBuffer`
		- `wrap()` method
		- `put()` / `get()` methods
- `ByteBuffer` example code
- Working with a `ByteBuffer`: Accounting for Primitive Sizes
	- `position()` method can set index we are start reading from / writing to
- Using the ByteBuffer to read / write binary files
- Data input and output streams
	- `DataInputStream`
		-`read()` methods for each primitive
	- `DataOutputStream`	
		- `write()` methods for each primitive
	- example code found in the lecture notes.
	
### [8. Selection Sort](08_selection_sort.md)

- Why its called a selection sort
- Pseudo code for selection sort
- Analysis of the comparisons and swaps involved: O(n^2) time complexity
	- this is not a great time complexity, but conceptually the sort is easy to understand.
	- Aside: best possible complexity for sorting algorithms is O(n * lg(n))
	- Time complexity is beyond the scope of this course, will discuss further in algorithms.
- Slightly optimized selection sort
	- only swap the next minimum found on the inner iteration
	- swaps are expensive, so this saves time
	- even though number of comparisons remains the same
	
### [9. Scanner / Exceptions / Wrappers / Lists](09_scanner_exceptions_wrappers_lists.md)

- Using `Scanner`
	- Parse `File`, `InputStream`, `String`, `ReadableBtyeChannel`
	- iteration can be done via a while loop
		- `hasNext()`
		- `next()`
	- supports parsing ***more data*** than `StringTokenizer` which only parses `Strings`
- Exception Handling
	- `try` block
	- `catch` block
	- catching multiple exceptions
		- order matters, more specific exceptions being caught should appear before more general exceptions being caught.
	- `finally` block
	- checked exceptions vs unchecked exceptions
		- specifies who is responsible for catching the exceptions
			- methods can specify they may throw some exception	
			- this delegates the work to the user to deal with exceptions which may be thrown, rather than the method which throws the exception
			```java
			public static void main(String[] args) throws java.io.IOException { ... }
			```
		
- Revisiting the Wrapper Classes
	- creates object version of each of the primitive types
		- `Boolean`, `Double`, `Float`, `Integer, `Long`, `Short`, `Byte`, `Character`
	- can use them with the various classes that only operate on objects
	- ArrayList and other data structures utilze java generics to specify the held type
		-ArrayList<Integer>, ArrayList<String>, etc.
	- autoboxing / unboxing	
	- Wrapper classes have other utility methods built in that can be convenient for dealing with operations involving primitive types
		- `Integer.parseInt(str)` : tries to convert some `String` `str` to an `int`  
		
### [10. Built-In Java Data Structures](10_builtin_java_data_structures.md)

- List Data Structures	
	- `ArrayDeque`, `ArrayList`, `Vector`
	- these are resizable list of objects
	- useful to store data where you don't initially know how much there is to be stored
	- methods: `add()`, `get()`, `set()`, `remove()`, `indexOf()`, `contains()`

- `ArrayLists` : resizable array implemtnation of the `List` interface.	

- `ArrayDeque`
	- supports functionality of both a ***queue*** and a ***stack***
	- queue = FIFO (first in first out, think line in grocery store) 
	- stack = LIFO	(last in first out, think function stack as program executes)
	- deque has a ***head*** and a ***tail***
	- methods: `push()`, `pop()`, `addLast()`, `getFirst()`, `pollFirst()`, `pollLast()`
	
- Set Data Structures
	- `HashSet`, `TreeSet`
	- stores a ***unique*** grouping of objects
	- implemented such that look up should be general quicker than trying to find values in a list
	- order of the elements are not garaunteed to be the same as they way they were added to the set 
	- methods: `add()`, `remove()`, `contains()`	
	
- `HashSet`
	- uses a `HashMap` (quicker lookup)
	- order of elements is undefined
	
- `TreeSet`
	- uses a `TreeMap` (quicker lookup)
	- elements are ordered by their ***natural order*** by default
		- can use `Comparator` to override the natural ordering if you wish	
		
- Using Enhanced for loops to iterate over Data Structures
- Using `Iterators` to iterate over Data Structures
- `toArray()` method can be used to put data from Data Structures into a corresponding array.	

- Example code
	- note: The `HashSet` had numbers printed out of order
	- note: The `TreeSet` had numbers printed in increasing order
	- note: `ArrayDeque` is used for both the stack and queue.
	- the key difference is that:
		- the queue utilized FIFO (`pollFirst()`)
			- resulted in printing values in the SAME order they were added to the queue
		- the stack utilized LIFO (`pollLast()`)	
			- resulted in printing values in REVERSE order they were added to the stack

### [11. OOP Basic Principles](11_oop_basic_basic_principles.md)			

- Classes
- Encapsulation
- `BankAccount` Example
- Class modifiers
- Acces modifiers
- static / non-static
- Constructors
- Inheritance
	- subclasses
	- superclasses
- Sealed classes	
- importing

### [12. More on Inheritance](12_more_on_inheritance.md)

- `EnhancedBankAccount` example
- `Transaction` example
- Subclassing -> maximize code reuse
- Upcasting / Downcasting / `instanceof`
- Polymorphism (Dynamic Dispatching)
- Records

### [13. More Introductory Info](13_more_introductory_info.md)

- the main method
- types of variables
	- instance variables
	- class variables
	- local variables
	- parameters
	- fields (instance and class variables)
- conventions naming variables
- conventions for constants
- variable scope
- variable declaration
- operations
	- addition, subtraction/negation, division, multiplication, logical and, logical or, logical negation 
	- short circuiting
- casting primitive types
- General coding practices
	- think high level first
	- work incrementally during implementation
	- debug / test your code

### [14. Lab04 and Program Assignment 03](14_lab04_and_program_assignment_3.md)

- More descriptions on these two assignments

### [15. Review Thus Far](15_review_thus_far.md)

- defining a class
- inheritance
- static vs non-static fields
- class methods
	- constructors
	- non-construct methods
	- static methods
	- non-static methods
	- overloaded methods
- subclassing
	- subclass, superclass, `extends`
	- java only suports *single inheritance*
- Objects
	- creating an instance at runtime, `new`
	- comparing objects
		- `==` vs `equals()`
- Accessing fields and methods of a class

### [16. Getting Ready for the Reaminder of Semester](16_getting_ready_for_remainder_of_the_semester.md)

- Expected Proficiency
- Refresher on parsing delimited text
	- `StringTokenizer`, `Scanner`, `String.split()`
- `HashSet` and `TreeSet`
- `ArrayDeque`

### [17. Graphs](17_graphs.md)

- Definition of Graph
	- Vertices / Edges
	- fromVertex, toVertex
- Undirected Graph
- Directed Graph
- Paths
- Connected Graphs / Unconnected Graphs / Strongly Connected Graphs
	- Algorithm for determining connected / strongly connected 
	- Compliment of a Graph

### [18. Testing and Intro to Interfaces](18_testing_and_interfaces_intro.md)

- Types of testing
	- unit testing
	- functional testing
	- integration testing
	- regression testing
	- performance testing
	- system testing
	- verification testing
	- validation testing

- Software Development
	- requirements
	- software design
	- software verification

- JUnit testing
	- assertions used to verify code works as we expect 
	- leverage expected vs actual values
	- tests should be repeatable and isolated

- Interfaces
	- specify the functions that must be implemented by a Java class that opts into implement the interface
	- abstract vs default methods
		- abstract methods have no function body, and must be defined by the class implementing the interface
		- default methods do have a function body. Implementing class can optionally override the default behavior but not required.
	- methods are implicitly public and abstract, unless otherwise specified.
	- also possible to define static methods, which also must have a function body provided.
	- fields in an interface are implicitly constants, ie static and final.
	- can implement multiple interfaces, can only extend one parent class.

### [19. Throwing Exceptions](19_throwing_exceptions.md)

- The `throw` statement
- `Exceptions` extend the `Throwable` class
- our `	Graph` class utilizes `GraphException`, a subclass of the `Exception` class.

### [20. Recursion](20_recursion.md)

- the factorial example
	- considering base cases and recursive cases
- Stack overflow
	- can occur if you don't have a well defined base case
	- can occur if your making a lot of function calls without the stack reducing in size
		- can increase your stack size with `-Xss` argument
		- the `ss` stands for Stack size.
- Thinking recursively
	- Divide and Conquer: break a problem up into similar sub problems.
	- Use the solutions to the sub problems to make it easier to define the problem currently at hand.
- Implementing the sum recursively
- Recursion relies heavily on the Stack
- the fibonacci numbers
	- relies on two base cases to define the general case
	- can be inefficient, needing to solve subproblems multiple times.
- Limitations of Recursion
	- the pros and cons are discussed
- Amortized Fibonacci
	- we can store the results of sub problems, to speed up our efficiency
	- increase our space complexity to lower our time complexity.

### [21. Trees](21_trees.md)

- Definition of a tree
	- connected, directed grapth, acyclic, has special root node.
- Terminology:
	- nodes, parent, child, leaf, height, ancestor, descendant
- Tree example
- Trees can be thought of recursively.
	- Trees are made up of smaller subtrees

### [22. Binary Search Trees](22_binary_search_trees.md)

- Definition of a BST
	- binary tree (each node has at most 2 children)
	- children to our left have keys strictly less than ours
	- children to our right have keys strictly greater than ours

#### Functionality 

- Inserting a node (***if node being inserted has key less than we we are, insert in the left subtree, otherwise insert in the right subtree***)
- deleting a node (***in general, a bit complicated***)     
- finding our successor (***least upper bound, the left most node in our right subtree***)
- finding our predecessor   (***greatest lower bound, the right most node in our left subtree***)
- finding our minimum (***keep going left until we no longer can***)
- finding our maximum (***keep going right until we no longer can***)
- searching (***similar to insertion, we go left or right depending on how where we are compares to the key being searched for***)
- Traversals
	- inOrder   (1. visit left,     2. visit yourself, 3. visit right)
	- preOrder  (1. visit yourself, 2. visit left,     3. visit right)
	- postOrder (1. visit left,     2. visit right,    3. visit yourself)

### Importance of Balancing a BST

- If the BST is perfectly balanced, then searching for values will be more efficient, O(lg n)
- if the BST is not balanced, the searching tends toward being linear, O(n)
- how the BST is structured depends on the order in which we add / delete nodes with various key values.
- algorithms exist to ensure a BST remains balanced, but that is beyond our scope.

#### BST implementation details
 - motivated by wikipedia. see notes and that for more details.
 - height is also discussed.



