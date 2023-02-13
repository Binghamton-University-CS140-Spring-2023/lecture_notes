---------------------------------------
Getting Ready for Remainder of Semester
---------------------------------------

## Expected Proficiency

- At this point in the semester, we should all be really good at
	- Reading lines of text from text files
	- Writing lines of text to text files
	- Parsing delimited text using either `StringTokenizer`, `Scanner`, or `String.split()`
	- Using primitive types
	- Arrays of primitive types
	- Looping
	- If statements
	- Try/catch blocks for exception processing

## Refresher on parsing delimited text

- I'm sure there are many other options, but here are three
	- StringTokenizer
	- Scanner
	- String.split()


**StringTokenizer**

- Given a `String inn`, to construct a StringTokenizer for inn, with a blank space delimiter:

```java
java.util.StringTokenizer st = new java.util.StringTokenizer(inn, “ “);
```
- The second parameter is optional, and is the delimiters that you want to use if you wish to override the default delimiters 
- See Java documentation for additional information on `StringTokenizer`

```java
- String inn = “aa bb cc dd ee ff”;
- java.util.StringTokenizer st = new java.util.StringTokenizer(inn, “ “);
```

**StringTokenizer's countTokens() method**

- `st.countTokens()` is the number of tokens - for this it is 6
- The `StringTokenizer` looks for the occurrence of delimiters in the `String`, and breaks the `String` into tokens, substring of the original string, based on where the delimiters are in the string

**StringTokenizer's nextToken() / hasMoreToken() methods**

- `st.nextToken()` will return the next token, as long as there are more tokens
- `st.hasMoreTokens()` will return true if the string has more tokens, false if not
- Typically used with a while loop

```java
while( st.hasMoreTokens() )
{
// put code here to process the current token
}
```

## Scanner

- Given a `String inn`, to construct a `Scanner` for `inn`, with a blank space delimiter:

```java
java.util.Scanner sc = new java.util.Scanner(inn);
sc.useDelimiter(“ “);
```
- See Java documentation for additional information on Scanner

**Scanners are more general use**
- Has more functionality than a `StringTokenizer` in that it can return types other than `String`
- I didn't see anything that equates to `StringTokenizer.countTokens()`

```java
String inn = “aa bb cc dd ee ff”;
java.util.Scanner sc = new java.util.Scanner(inn);
sc.useDelimiter(“ “);
```

**Scanner's hasNext() / next() methods**

- `sc.hasNext()` returns true if there are more tokens, false if not
- `sc.next()` returns the next token as a string
- Typically used with a while loop

```java
while( sc.hasNext() )
{
// put code here to process the current token
}
```

## String.spilt()
- Given a `String inn`, to have it “split” into tokens via the `String.split()` method with a blank space delimiter:

```java
inn.split(“ “);
```
- Example
```java
String inn = “aa bb cc dd ee ff”;
String[] tokens = inn.split(“ “);
//Use a for loop to loop over the tokens returned by split
for( int i = 0; i < tokens.length; i++ )
{
// put code here to process the current token
}
```

- Sample code

```Java
import java.util.Scanner;
import java.util.StringTokenizer;
public class Parsing {
	public static void main(String[] args) {

		//Parse via StringTokenizer - space delimiter
  		String inn = "one two three four";
      	System.out.println("inn = " + inn);
	  	System.out.println("delimiter = \" \"");
	    StringTokenizer st = new StringTokenizer(inn, " ");
	    System.out.println("st.countTokens() = " + st.countTokens());
	    System.out.println("StringTokenizer");
	    while(st.hasMoreTokens()) {
	    	System.out.println(st.nextToken());
	    }
	    System.out.println();

	    //Parse via Scanner - space delimiter
	    inn = "one two three four";
	    Scanner sc = new Scanner(inn);
	    System.out.println("Scanner");
	    while(sc.hasNext()) {
	    	System.out.println(sc.next());
	    }
	    System.out.println();

	    //Parse via String.split() - space delimiter
	    inn = "one two three four";
	    String[] splt = inn.split(" ");
	    System.out.println("String.split()");
	    for(var str : splt) {
	    	System.out.println(str);
	    }
	    System.out.println();

		//Parse via StringTokenizer - comma delimiter
	    inn = "one,two,three,four";
	    System.out.println("inn = " + inn);
	    System.out.println("delimiter = \",\"");
	    st = new StringTokenizer(inn, ",");
	    System.out.println("st.countTokens() = " + st.countTokens());
	    System.out.println("StringTokenizer");
	    while(st.hasMoreTokens()) {
	    	System.out.println(st.nextToken());
	    }
	    System.out.println();

	    //Parse via Scanner - comma delimiter
	    inn = "one,two,three,four"; 
	    sc = new Scanner(inn);
	    sc.useDelimiter(",");
	    System.out.println("Scanner");
	    while(sc.hasNext()) {
	    	System.out.println(sc.next());
	    }
	    System.out.println();

	    //Parse via String.split() - comma delimiter
	    inn = "one,two,three,four";
	    splt = inn.split(",");
	    System.out.println("String.split()");
	    for(var str : splt) {
	    	System.out.println(str);
	    }
	}
}
```

- Showcases utilizing all three to parse some text, with space as a delimiter, and then comma as a delimiter
	- `StringTokenizer` to parse the text of the line using the specified delimiter
  	- `Scanner` to part the parse of the line using the specified delimiter
  	- `String.split()` to parse the text of the line using the specified delimiter
    - Outputs the tokens for each of the three ways to parse the `String`

- Output

```
inn = one two three four
delimiter = " "
st.countTokens() = 4
StringTokenizer
one
two
three
four

Scanner
one
two
three
four

String.split()
one
two
three
four

inn = one,two,three,four
delimiter = ","
st.countTokens() = 4
StringTokenizer
one
two
three
four

Scanner
one
two
three
four

String.split()
one
two
three
four
```      

## HashSet and TreeSet

- `HashSet` and `TreeSet` are two class for storing sets of objects
	- Store a collection of unique objects – like a real set
	- The `HashSet` does not guarantee an order of the elements of the set
	- The `TreeSet` guarantees the elements will be ordered in their natural order (or an order that you override the natural ordering with)

## ArrayDeque

- `ArrayDeque` is a class with the functionality a queue (FIFO list) and a stack (FILO/LIFO list)
	- Add elements to the `ArrayDeque` similar to an `ArrayList` with the add method (adds to tail or end)
	- Use `pollFirst()` to remove elements from the front of the list (queue functionality)
	- Use `pollLast()` to remove elements from the tail (or end) of the list (stack functionality)
	- The `ArrayDeque` keeps track of all the pointers for you
		- Where is the front/head of the list
		- Where is the end/tail of the list
		- How many elements are in the list
		- Grows when needed
		- Can check how many elements in the list with size method
		- Can remove elements from the head/front and tail/end intermingled

- Sample code

  - `TestTreesAndDeque1.java`
      - Creates a `HashSet`, `TreeSet`, queue `ArrayDeque`, and stack `ArrayDeque` with `Integer` objects for each of the command-line arguments
      - Outputs the `HashSet` and `TreeSet` with the enhanced for loop to show `HashSet` does not maintain order, while `TreeSet` does
           - Also shows it remove duplicates
      - Outputs the queue and stack versions of the `ArrayDeque` to show how queue output in the order the values were added, which the stack outputs in reverse order

```Java
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
public class TestTreesAndDeque1 {
	public static void main(String[] args) {
		double[] ref = {115, 120, 122, 118, 117, 16, 120, 118, 122, 14, 11, 110, 10,
				119, 12, 112, 13, 115, 17, 16, 115, 15, 124, 18, 15, 17,
				23, 17, 23, 1, 18, 23, 13, 17, 22, 6,
				123, 117, 123, 11, 118, 123, 113, 117, 122, 16,
				115, 111, 15, 122, 16, 123, 19, 13, 15, 119, 110, 10, 14, 18,
				15, 11, 5, 22, 6, 23, 9, 3, 5, 19, 10, 0, 4, 8,
				15, 20, 22, 18, 17, 6, 20, 18, 22, 4, 1, 10, 0,
				19, 2, 12, 3, 15, 7, 6, 15, 5, 24, 8, 5, 7};
		double[] reverse = new double[ref.length];
		for(int i = 0; i < ref.length; i++) reverse[i] = ref[ref.length - i - 1];

		HashSet<Double> hashSet = new HashSet<>();
		TreeSet<Double> treeSet = new TreeSet<>();
		ArrayDeque<Double> queue = new ArrayDeque<>();
		ArrayDeque<Double> stack = new ArrayDeque<>();

		System.out.println("input");
		System.out.println(Arrays.toString(ref));
		System.out.println("reverse");
		System.out.println(Arrays.toString(reverse));

		for(int i = 0; i < ref.length; i++) {
			hashSet.add(ref[i]);
			treeSet.add(ref[i]);
			queue.add(ref[i]);
			stack.add(ref[i]);
		}

		// output the HashSet
		System.out.println("HashSet");
		for(Double v : hashSet) {
			System.out.print(v + " ");
		}
		System.out.println();

		// output the TreeSet
		System.out.println("TreeSet");
		for(Double v : treeSet) {
			System.out.print(v + " ");
		}
		System.out.println();

		// output the ArrayDeque as a queue
		System.out.println("ArrayDeque as queue");
		while(queue.size() > 0) {
			Double v = queue.pollFirst();
			System.out.print(v + " ");
		}
		System.out.println();

		// output the ArrayDeque as a stack
		System.out.println("ArrayDeque as stack");
		while(stack.size() > 0) {
			Double v = stack.pollLast();
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
```

- Running and output
 - `HashSet` does not maintain sorted order, 20 outputs prior to 10
 - `TreeSet` maintains sorted order of the values
 - `ArrayDeque` as a queue output the values in the order entered
 - `ArrayDeque` as a stack outputs the values in  reverse order that they were entered

```
input
[115.0, 120.0, 122.0, 118.0, 117.0, 16.0, 120.0, 118.0, 122.0, 14.0, 11.0, 110.0, 10.0, ...
reverse
[7.0, 5.0, 8.0, 24.0, 5.0, 15.0, 6.0, 7.0, 15.0, 3.0, 12.0, 2.0, 19.0, 0.0, 10.0, 1.0, ...
HashSet
0.0 2.0 3.0 4.0 5.0 6.0 110.0 111.0 115.0 112.0 113.0 7.0 118.0 117.0 119.0 120.0 122.0 ...
TreeSet
0.0 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0 18.0 ...
ArrayDeque as queue
115.0 120.0 122.0 118.0 117.0 16.0 120.0 118.0 122.0 14.0 11.0 110.0 10.0 119.0 12.0 ...
ArrayDeque as stack
7.0 5.0 8.0 24.0 5.0 15.0 6.0 7.0 15.0 3.0 12.0 2.0 19.0 0.0 10.0 1.0 4.0 22.0 18.0 ...
```