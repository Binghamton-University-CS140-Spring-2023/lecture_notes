-------------------------------
Built-In Java Data Structures
------------------------------- 

# List Data Structures in Java

- Java has an assortment of classes for working with **lists** of objects
- Three such classes are `ArrayDeque`, `ArrayList`, and `Vector`
- All three act as a **resizable** list of objects
- All three have a `contains()` method

**ArrayLists and Vectors**

- `ArrayList` and `Vector` are very similar
- `Vector` being thread-safe and `ArrayList` not being thread-safe
	- The java documentation mentions using `ArrayList` instead of `Vector` if you do not need a thread-safe data structure
- Both have methods to:
	- `add()`
	- `get()`
	- `set()`
	- `remove()`
	- `indexOf()` 
	
**More on ArrayLists**

- According to the Java documentation, an ArrayList is:
	- “Resizable-array implementation of the List interface.”
- According to the Java documentation, on the List interface:
 	- “An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.”

- Has methods to:
	- Add elements
	- Get elements
	- Search for elements
	- Remove elements
	- Return the number of elements
	- Return an array copy
	- Delete all elements
	
**ArrayDeque**

- `ArrayDeque` supports the functionality of both a **queue** and a **stack**
- A *queue* is a FIFO (first in first out) data structure
	- similar to an escalator (people get off the escalator in the order they get on)
	- or a shopping line (people that got in line first get checked out first)
- A *stack* is a FILO or LIFO (first in last out or last in first out) data structure
	- similar to a garbage can (the stuff put in the garbage can first, comes out last)
	- or a stack of pancackes (you typically eat the pancake on top before getting to those underneath)
- Has methods to:
	- add to the tail / end
	- add to the head / beginning
	- get and remove from the beginning
	- get and remove from the end
- You can tailor your use of the `ArrayDeque`, depending on the context in which you are utilizing the data structure
- The `ArrayDeque` keeps track of all the pointers for you
	- Where is the front/head of the list
	- Where is the end/tail of the list
	- How many elements are in the list
	- Grows when needed
	- Can check how many elements in the list with `size()` method
	- Can remove elements from the head/front and tail/end intermingled
	
**ArrayDeque push() and pop() methods**
	
- Has `push()` and `pop()` methods, which are functions typically associated with a stack
	- `push()` adds a new element to a stack, conceptually at the *top* of the stack
	- `pop()` removes the last element of a stack, conceptually at the *top* of the stack

**ArrayDeque - addLast() and getFirst() methods**

- Has `addLast()` and `getFirst()` methods, typically asociated with queue-like functionality
	- `addLast()` adds a new element at the end of the queue
	- `getFirst()` retreives, but does NOT remove the first element of the queue
	
**ArrayDeque - pollFirst() and pollLast() methods()**
	
- Has `pollFirst()` and `pollLast()` methods to retrieve from either end and remove the value
	- `pollFirst()` retrieves and removes the element from the front of the list queue
	- `pollLast()` retrieves and removes the element from the tail (or end) 

# Set Data Structures in Java

- Java has classes for working with **sets** of objects
	- `HashSet` 
	- `TreeSet`
- Both have methods to:
	- add elements
	- remove elements
	- check if an object is an element of the set
	- return an array of the elements
	- return an `Iterator` for the set
	
**HashSet and TreeSet**

- `HashSet` and `TreeSet` are two classes for storing sets of objects
	- Store a collection of unique objects – like a real set

**HashSet**

- The `HashSet` class uses a `HashMap`
- The order of the elements in the HashSet is undefined (no guaranteed order)

**TreeSet**

- The `TreeSet` class uses a `TreeMap`
- The elements are ordered by:
	- their natural order or 
	- via a `Comparator` if you want to override the natural ordering

**Utilizing Enhanced for Loops over Data Structures**	

- If `hashSet` is a `HashSet<Integer>`, then the below will step though the elements of `hashSet`:

``` java
for(Integer currentIntegerValue : hashSet)
{
	//put code here
}
```

**Utilizing Iterators to iterate over Data Structures**

- If `hashSet` is a `HashSet<Integer>`, then the below will step though the elements of `hashSet`:

```java
java.util.Iterator<Integer> hashSetIterator = hashSet.iterator();
while( hashSetIterator.hasNext() ) 
{
	Integer i = hashSetIterator.next();
	// put code here
}
```

**Utilizing the `toArray()` method**

- If `hashSet` is a `HashSet<Integer>`, then the below will get an `Integer` array of the elements of `hashSet` and loop over them:

```java
Integer[] hashSetArray = hashSet.toArray(new Integer[0]);
for( int i = 0; i < hashSetArray.length; i++ )
{
// put code here 
}
```

- Note: there are two versions for the `toArray()` method
	- `ToArray()` returns an array of Objects
	- `toArray(T[] array)` returns an array of type T
		- if there is room in array for all of the elements, then they are returned in it
		- otherwise a new array of type T is returned
		
		
- If `hashSet` is a `HashSet<Integer>`, then the following returns an array of `Integer`s of the elements of `hashSet`:
	- `Integer[] hashSetArray = hashSet.toArray(new Integer[0]);`
	- If `hashSet` contains any elements, then a new array of type `Integer` will be returned

- The enhanced for loop, `Iterator`, and `toArray()` method should work with the other list classes (`ArrayDeque`, `ArrayList`, `Vector`, and others)

# Sample code
  - `TestTreesAndDeque1.java`
      - Creates a `HashSet`, `TreeSet`, queue `ArrayDeque`, and stack `ArrayDeque` with `Integer` objects for each of the command-line arguments
      - Outputs the `HashSet` and `TreeSet` with the enhanced for loop to show `HashSet` does not maintain order, while `TreeSet` does
           - Also shows duplicates don't appear in the set
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

		// output the ArrayDeque as a queue (FIFO)
		System.out.println("ArrayDeque as queue");
		while(queue.size() > 0) {
			Double v = queue.pollFirst();
			System.out.print(v + " ");
		}
		System.out.println();

		// output the ArrayDeque as a stack (LIFO)
		System.out.println("ArrayDeque as stack");
		while(stack.size() > 0) {
			Double v = stack.pollLast();
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
```

**Running and output**

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
