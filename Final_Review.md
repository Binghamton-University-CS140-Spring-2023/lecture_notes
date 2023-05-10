-------------
Final Review
-------------

- **DISCLAIMER:** The material covered here may not include everything you will be tested on for your final exam.

- **Reminder:** Final will be held ***Thursday, May 11th, 12:50 pm - 2:50 pm***
	- Professor Garrison and I are still deciding if it will be in person or online
	- If in person, we are booked for ***Lecture Hall 14***
	- I will send you an email as soon as the decision is made.

# Review topics

Let's dive in. 

## Previous Quiz Material

- Definitely recommend reviewing previous quizzes as well.

- [Quiz 1 and 2 review](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/Quiz_12_Review.md)
- [Quiz 3 and 4 review](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/quiz_3_4_review.md)

## [Object Oriented Programming](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/11_oop_basic_basic_principles.md)
	
- [OOP is a programming paradigm](https://stackify.com/oops-concepts-in-java/)
	- Other paradigms include Procedural Programming and Functional Programming
	- You'll spend time juxtaposing these paradigms in programming languages
- Class vs instance
- abstraction
	- abstract classes
	- interfaces
- encapsulation
	- access modifiers
- Inheritance
- Polymorphism 
	- method overriding
	- method overloading

## Primitive Types

- You have seen that these topics are semi related. 
- Be sure you know the byte size of primitive types
- Review quiz questions involving ByteBuffer.

- [byte sizes](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/01_primitive_data_types.md)
- [ByteBuffer](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/07_more_on_reading_and_writing_files.md#reading-and-writing-data-from-a-byte-array)

## [Represent numbers in different bases](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/01_primitive_data_types.md)

## [Control Flow](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/02_flow_control.md)

- do while, while, for loops

## [Iterators](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/32_iterators.md)

- compare with traditional for loop and enhanced for loop.

## [Big O Notation](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/25_big_oh_notation.md)

## Sorting review

- [selection sort](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/08_selection_sort.md)
- [merge sort](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/37_merge_sort.md)
- what is the best time complexity a sort can have in general?

## Data Structures

- Trees, Binary Search Trees, Complete Trees
- [Priority Queue, Heaps, Stack, Queue, ArrayDeque, HashSet, TreeSet](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/10_builtin_java_data_structures.md)
- ArrayList, Vector, LinkedList
- [Arrays](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/03_arrays_of_primitive_types.md)
	- multi-dimensional
	- jagged arrays
- [HashMaps, TreeMaps](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/29_hash_map_and_tree_map.md)
- [Heaps](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/43_heapsort.pdf)

### [Trees](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/21_trees.md)

- root
- ancestors
- decendents
- parents
- children
- leaves
- height
- complete tree -> priority queues, heaps	

### [Binary Search Trees](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/22_binary_search_trees.md)
- Insert
- Find
- Delete
- Predecessor, Successor
- Pre order, Post order, In order
- Max / Min
- Height

### [Graphs](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/17_graphs.md)

- definition G = (V, E) where E = V x V
- directed / undirected
- connected vs disconnected
- definition of a path
- strongly connected
- Adding edges to make a undirected graph connected
- Adding edges to make a directed graph strongly connected
- testing for whether graph is connected / strongly connected

### [Weighted Graphs](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/26_weighted_graphs.md)

- definition G = (V,E) where E = V x V x R
- Shortest cost path -> Dijkstra's algorithm
- Breadth First Search vs Depth First Search

## Parsing Strings

- [StringTokenizer](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/05_reading_files.md#parsing-text)
- String[] via split
- [Scanner](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/09_scanner_exceptions_wrappers_lists.md)  

## [Function Overloading](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/15_review_thus_far.md)

## [Exception Handling](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/09_scanner_exceptions_wrappers_lists.md)

## [Recursion](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/20_recursion.md)

- example where we can solve via "amoritization"
- example where we can solve via working out on stack
- Stack Overflow
- Base case / recursive case
- Divide and Conquer 

## Inheritance

- Every object implicitly extends the [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) class in java
	- toString()
	- [hashCode()](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/39_hashcode_in_classes.md)
	- [equals()](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/15_review_thus_far.md#comparing-objects)
- [Polymorphism](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/12_more_on_inheritance.md#polymorphism---dynamic-dispatching)
	- overriding methods
	- dynamic dispatching
- Maximize Code Reuse
- Inherited fields / methods
- [Upcasting vs Downcasting](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/12_more_on_inheritance.md#casting-objects)
	- `instanceof` keyword
- GrandParent / Parent / Child
- Single Inheritance vs Multi Inheritance
	- which does Java support?
	- why doesn't it support the other? what problem does it avoid that exists in say c++?

## [Interfaces](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/18_testing_and_interfaces_intro.md#java-interfaces)

- Compare and contrast abstract and default methods.
- Does java allow a single class to implement multiple interfaces?
- Which of the following are legal in Java? 
	- have a class extending two parent classes
	- have class extending a subclass and an interface
	- have class implementing two interfaces
- Suppose a class B extends a class A and implements some interface C with abstract methods
	- Suppose further that the class being extended already implemented a subset of the abstract methods found in the interface.
	- what methods need to be implemented in class B for it to be considered a `concrete class`?
	- **Note:** [Concrete vs Abstract classes](https://www.geeksforgeeks.org/difference-between-abstract-class-and-concrete-class-in-java/)

## Java passes variables to methods **by value**, not by reference. 

## Implementing `toString()` and `equals()` methods

## [Comparators](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) and [PriorityQueues](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)

## [JUnit Testing](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/18_testing_and_interfaces_intro.md)

- which pass? which fails?

## [Streams](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/40_java_streams.md)

## [Threading](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/24_multi_threaded_applications.md)
- Compare and contrast threading with processes.
	- Briefly discuss in the context of the scheduler of yours Operating System on the CPU
- Describe how threading can be leveraged in Java
	- `Thread` class and `Runnable` interface
	- Explain the relevance and compare and contrast [the following methods](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/24_multi_threaded_applications.md#some-methods-in-the-thread-class) in a threading context:
		- `start()`
		- `run()`
		- `sleep()`
		- `isAlive()`
		- [`join()`](https://stackoverflow.com/questions/6594388/why-we-should-use-join-in-threads)
		- which method needs to be implemented for threading to work?
		- what happens if we call `start()` vs calling `run()`? 
- What are the benefits you can get from threading?
	- What is [concurency](https://docs.oracle.com/cd/E19253-01/816-5137/mtintro-25092/index.html#:~:text=Concurrency%20indicates%20that%20more%20than,might%20appear%20to%20run%20simultaneously.)?
	- [Thread Scheduling](https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/priority.html#:~:text=The%20execution%20of%20multiple%20threads,defined%20in%20the%20Thread%20class)
- What are some of the issues you can run into with threading?
	- What is a shared resource in the context of threading?
	- What is a critical section?
	- What is a race condition, and **how can we avoid them in java**?
		- [Semaphores](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/24_multi_threaded_applications.md#1-utilizing-sempaphores) 
			- `aquire()` and `release()`
			- threads that can aquire a semaphore are dictated by the number of `permits`
		- [`synchronized` keyword](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/24_multi_threaded_applications.md#2-utilizing-synchronized-methods)
		- [ReentrantLock](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/24_multi_threaded_applications.md#3-utilizing-reentrant-locks) 
			- `lock()` and `unlock()`
			- mutually exclusive
	- What is [deadlock](https://www.developer.com/java/java-prevent-thread-deadlock/#:~:text=Deadlock%20can%20be%20avoided%20by,lock%20on%20the%20same%20resource.), and how can we avoid it?
	- What is an [atomic instruction](https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html)?

# Review Questions

## Control Flow

1. What does the following code do?

``` java
	public static java.util.ArrayList<String> do_while_example()
	{
		java.util.ArrayList<String> ret = new java.util.ArrayList<>();

		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		String user_input = "";
		do
		{
			System.out.print("user input: ");
			user_input = keyboard.nextLine();
			ret.add(user_input);
		}while(user_input != "");

		ret.remove(ret.size() - 1);

		return ret;
	}
```

2. The following is an implementation of [euclidean's algorithm](https://en.wikipedia.org/wiki/Euclidean_algorithm). 


``` java
	public static void gcd_euclid(int A, int B)
	{
		int gcd = Math.max(A,B);
		int r 	= Math.min(A,B); 

		while(r != 0)
		{
			gcd = r;

			int larger  = Math.max(A,B);
			int smaller = Math.min(A,B);

			int q 	= larger / smaller;
			r 		= larger - (q * smaller);

			System.out.println(larger + " = " + q + "(" + smaller + ") + " + r);

			A = smaller;
			B = r;
		}

		System.out.println("Conclusion: The gcd is: " + gcd);
	}
```

- What's the output, given A and B are multiples of one another?
	- Consider: A = 21, B = 7
	- Consider: A = 5, B = 45 
- What's the output, given A and B have common factors in their prime factorizations?
	- Consider: A = 49, B = 21
- What's the output of two relatively prime numbers?
	- Consider: A = 35, B = 6
- What's the output, given A or B is 0?
	- Consider: A = 41, B = 0

3. What's the output?

``` java
	public static void for_example()
	{
		int[] vals = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,2,13,14,15,16,17,18,19,20};

		for(int i = 1; i < vals.length; i *= 2)
		{
			System.out.println("vals[" + i + "] = " + vals[i]);
		}
	} 
```

## Iteration

4. Print out the `String[]` passed to this function, utilizing:
	- tradition for loop, enhanced for loop, an iterator

``` java
public static void iteration_example(String[] strArray)
{
	//TODO - print all values via a traditional for loop.

	//TODO - print all values via an enhanced for loop.

	//TODO - print all values via an iterator.
}
```

## Big Oh Notation

5. What is the time complexity of the following function?

``` java

public static void func1(int[] arr)
{
	int sum = 0;

	for(int i = 0; i < arr.length; ++i)
	{
		sum += arr[i];
	}

	int product = 1;

	for(int j = 0; j < arr.length; ++j)
	{
		product *= arr[i];
	}

	System.out.println("sum: " + sum);
	System.out.println("product: " + product);
}
``` 

6. What is the time complexity of the following function?

``` java
public static void func2(int[] arr)
{
	for(int i = 0; i < arr.length; i *= 2)
	{
		for(int j = 0; j < arr.length; ++j)
		{
			System.out.println(arr[j]);
		}
	}
}
```

7. What is the time complexity of the following function?

``` java
public static void func3(int[] arr)
{
	for(int i = 0; i < arr.length; ++i)
	{
		for(int j = 0; j < arr.length; ++j)
		{
			System.out.println(arr[i] + arr[j]);
		}
	}
}
```

8. What is the time complexity of the following function?

```java
public static void func4(int[] arr1, int[] arr2)
{
	int N = arr1.length;
	int M = arr2.length;

	for(int i = 0; i < N; ++i)
	{
		System.out.println(arr1[i]);
	}

	for(int j = 0; j < M; ++j)
	{
		System.out.println(arr2[j]);		
	}
}
```

9. What is the time complexity of the following function?

```java
public static void func5(int[] arr1, int[] arr2)
{
	int N = arr1.length;
	int M = arr2.length;

	for(int i = 0; i < N; i *= 2)
	{
		for(int j = 0; j < M; ++j)
		{
			System.out.println(i + " "  + j);
		}
	}
}
```

## Data Structures

10. Suppose you want to design a game, where we dynamically decide where each character lies on the leader board.  The players are placed on the board according to the following criteria:  
	- Whoever has the most overall points is in the lead.
	- If there is a tie, whoever has the most characters in their party leads.
	- If there is still a tie, whoever has the most money leads.
	- If there is still a tie, whoever has a user name that comes first alphabetically leads.

What data structure(s) would you utilize to be able to easily keep track of the leader board as the game progresses? Note that there could be multiple acceptable answers here.

Give a high level design describing how you would implement this logic.

11. Suppose you want to represent the files and subdirectories that reside within your operating system, starting at your Desktop directory. What data structure would you utilize to do this?  

12. Suppose you want to represent all the possible routes you could take to go from one point in a town to another. What data structure would you utilize to accomplish this?

13. Suppose you are given a task, where you are parsing XML data. The XML data looks something like so:

```
<XML>
	<CLASS>
		<NAME>Person</NAME>
		<FIELD>
			<AccessModifier>private</AccessModifier>
			<TYPE>String</TYPE>
			<NAME>firstName</NAME>
		</FIELD>
		<FIELD>
			<AccessModifier>private</AccessModifier>
			<TYPE>String</TYPE>
			<NAME>lastName</NAME>
		</FIELD>
		<FIELD>
			<AccessModifier>private</AccessModifier>
			<TYPE>int</TYPE>
			<NAME>age</NAME>
		</FIELD>

		<GETTER_METHOD>
			<AccessModifier>public</AccessModifier>
			<ReturnType>String</ReturnType>
			<NAME>getFirst</NAME>
			<Returned_Field>fistName</Returned_Field>
		</GETTER_METHOD>
		<SETTER_METHOD>
			<AccessModifier>public</AccessModifier>
			<ReturnType>void</ReturnType>
			<NAME>setAge</NAME>
			<PARAM>
				<TYPE>int</TYPE>
				<NAME>newAge</NAME>
			</PARAM>
			<Set_Field>age</Set_Field>
		</SETTER_METHOD>
	</CLASS>
</XML>
```

And we would want to write some code, such that we auto generate the following java file:

```java
class Person
{
	private String firstName;
	private String lastName;
	private int age;

	public String getFirst()
	{
		return lastName;
	}

	public void setAge(int newAge)
	{
		age = setAge;
	}
}
```

When writing the code, note here that The XML tags can mean different things depending on the context. For example, <AccessModifier>  is a tag which could be associated with a Field or a Method. Likewise, <NAME> and <TYPE> are tags that could be associated with parameters, fields, or methods.

In order to properly process the XML and the nested nature of it, what data structure would you utilize here? 

**Note:** When you are done processing say a <FIELD> </FIELD> area, we need to know that we are still within a class here. Describe how the chosen data structure would change when you are changing contexts being considered parsing the XML here. 


14. Suppose you want to design an app that keeps track of a bunch of user names, and for each user, keeps track of their:
	- phone number
	- their address
	- their email address
	- the company they work for

What data structure would you utilize to represent this data?

15. Suppose you are given a task where you are given a roster of all the clubs at binghamton university. From that data, you want to know how many unique students are in all of the clubs collectively in total.

What data structure could you utilize to make this task simple?

16. Suppose are designing a simple traffic handler for a website. When multiple users request access to information related to the website, let's suppose for the sake of simplicity that you can only honor the requests one at a time. 

We probably want to honor the user's that made their request first, since they would have been waiting the longest as more requests come in.

What data structure could you utilize to make sure all the user requests are handled in the order they have been receieved? 

## Inhertiance

17. Suppose the following code is provided:

```java
class A
{
	public int binaryOperator(int x, int y)
	{
		return x + y;
	}
}

class B extends A 
{
	public int binaryOperator(int x, int y)
	{
		return super.binaryOperator(2*x - y, y);
	}
}

class C extends B 
{
	public int binaryOperator(int x, int y)
	{
		return super.binaryOperator(x, 1) * super.binaryOperator(y, 2);
	}
}
```

What is the output of the following:

```java

public static void main(String[] args)
{
	A a = new A();
	B b = new B();
	C c = new C();

	ArrayList<A> objects = new ArrayList<>();
	objects.add(a);
	objects.add(b);
	objects.add(c);

	for(A obj ; objects)
	{
		System.out.println(obj instanceof Object);
		System.out.println(obj instanceof A);
		System.out.println(obj instanceof B);
		System.out.println(obj instanceof C);
		System.out.println(obj.binaryOperator(4,5));
		System.out.println("----------------------");
	}
}
```

## Java Passes Variables by Value

18. What is the output of the following code?

```java
class Book
{
	private String title;
	private String authorName;
	private int pages;

	public Book(String title, String authorName, int pages)
	{
		this.title = title;
		this.authorName = authorName;
		this.pages = pages;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	public void setPages(int pages)
	{
		this.pages = pages;
	}

	public String toString()
	{
		return title + " (" + pages + ") - " + authorName;
	}
}

class Driver
{
	public static void modifier(java.util.ArrayList<Book> library, Book b, int x, int y)
	{
		library.add(b);
		library.add(b);
		library.add(b);

		b.setTitle("Moby Dick");
		b.setAuthorName("Herman Melville");
		b.setPages(427); 

		b = new Book("A Tale of Two Cities", "Charles Dickens", 448);

		x = x + y;
		y = x - 2*y;
	}

	public static void main(String[] args)
	{
		java.util.ArrayList<Book> library = new java.util.ArrayList<>();
		Book b = new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 600);
		int x = 3;
		int y = 7;

		modifier(library, b, x, y);

		System.out.println("library: " + library);
		System.out.println("Book:    " + b);
		System.out.println("x:       " + x);
		System.out.println("y:       " + y);
	}
}
```

## Comparisons in Java

19. Given the following class, implement the TODOs correctly.


``` java
class Dog
{
	private String name;
	private String breed;
	private int age;
	private double weight_lbs;

	public Dog(String name, String breed, int age, double weight_lbs)
	{
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight_lbs = weight_lbs;
	}

	public String toString()
	{
		return "(" + name + "," + age + "," + weight_lbs + ")";
 	}

 	public boolean equals(Object other)
 	{
 		//TODO - other object should only be considered equal if is
 		//non-null, a Dog object, and has the same name, breed, age, and weight.
 		return false;
 	}
}

class DogComparator implements Compare<Dog>
{
	public int compare(Dog d1, Dog d2)
	{
		//TODO 
		//older dogs should be considered greater than younger dogs
		//if they are the same age, heavier dogs should be considered greater than lighter dogs
		//if they are the same age and weight, breeds should be compared lexicographically
		//if they are the same age, weight, and breed, names should be compared lexicographically.
		//if two dogs have the same age, weight, breed, and name, they should be considered equal
		return 0;
	}
}

class DogDriver
{
	public static void main(String[] args)
	{
		java.util.PriorityQueue<Dog> pq = new PriorityQueue<>(new DogComparator());

		pq.add(new Dog("Zeus", "Pug", 3, 20.2));
		pq.add(new Dog("Micah", "Chihuahua", 4, 6.3));
		pq.add(new Dog("Chewbacca", "Shihi Tzu", 5, 7.2));
		pq.add(new Dog("Bell", "Golden Retriever", 3, 30.1));
		pq.add(new Dog("Zeus", "Pug", 3, 20.2));

		while(!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}
}
```

## Streams

20. What is the output?

```java
List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
long count = strList.stream() .filter(x -> x.isEmpty()) .count();
System.out.println(count);
```

21. What is the output?

```java
List<Integer> intList = Arrays.asList(1,2,3,1,2,4,5,6,7,1,1,22,9,9,9,9,9,9,9,9,9,9,9,9,9,9);

int result = intList.stream()
					.limit(12)
					.distinct()
					.filter(x -> x % 2 == 1)
					.map(x -> 3*x)
					.reduce(0, (a,b)-> a + b);
					
System.out.println(result);
```