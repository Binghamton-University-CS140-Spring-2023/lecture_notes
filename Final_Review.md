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

## [Object Oriented Programming](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/11_oop_basic_basic_principles.md)
	
- [OOP is a programming paradigm]((https://stackify.com/oops-concepts-in-java/)
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

- [byte sizes](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/01_primitive_data_types.md)
- [ByteBuffer](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/07_more_on_reading_and_writing_files.md#reading-and-writing-data-from-a-byte-array)

## [Represent numbers in different bases](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/01_primitive_data_types.md)

## [Control Flow](https://github.com/Binghamton-University-CS140-Spring-2023/lecture_notes/blob/main/02_flow_control.md)

- do while, while, for loops
- find A and B such that the sum is equal to some value

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
	- Explain the relevance and compare and contrast the following methods in a threading context:
		- `start()`
		- `run()`
		- `sleep()`
		- `isAlive()`
		- [`join()`](https://stackoverflow.com/questions/6594388/why-we-should-use-join-in-threads)
		- which method needs to be implemented for threading to work?
		- what happens if we call `start()` vs calling `run()`? 
- What are the benefits you can get from threading?
	- What is [concurency](https://docs.oracle.com/cd/E19253-01/816-5137/mtintro-25092/index.html#:~:text=Concurrency%20indicates%20that%20more%20than,might%20appear%20to%20run%20simultaneously.)?
	- [Thread Scheduling](https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/priority.html#:~:text=The%20execution%20of%20multiple%20threads,defined%20in%20the%20Thread%20class).)
- What are some of the issues you can run into with threading?
	- What is a shared resource in the context of threading?
	- What is a critical section?
	- What is a race condition, and **how can we avoid them in java**?
		- Semaphores 
			- `aquire()` and `release()`
			- threads that can aquire a semaphore are dictated by the number of `permits`
		- `synchronized` keyword
		- ReentrantLock 
			- `lock()` and `unlock()`
			- mutually exclusive
	- What is [deadlock](https://www.developer.com/java/java-prevent-thread-deadlock/#:~:text=Deadlock%20can%20be%20avoided%20by,lock%20on%20the%20same%20resource.), and how can we avoid it?
	- What is an [atomic instruction](https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html)?
