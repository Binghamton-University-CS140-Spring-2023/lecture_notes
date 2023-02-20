# Quiz 1 and 2 Topics

- Arrays
- Reading & writing lines from a **text** file
- Reading & writing to a **binary** file
- Primitive types
- `Integer` representation (binary, octal, decimal, hexadecimal)
- `ByteBuffer`
- Exception handling
- looping (`for`, `while`, `do` while)
- `if` statement
- `switch` statement
- `break` statement
- `continue` statement
- `StringTokenizer`
- Converting strings to ints

# Quiz 1 / 2 Review

## DISCLAIMER: The following does NOT embody everything you will need to know for the quiz on Wednesday.

## Conversions

1. In java, how would you represent `124` as:
	- decimal
	- binary
	- octal
	- hexadecimal

## Arrays

2. Suppose I want to store all the items in a building within a single data structure.
	- The building is made up of FLOOR_COUNT floors. 
	- Each floor is made up of ROOM_COUNT rooms. 
	- Each room holds BOX_COUNT boxes.
	- Each box holds some number of items.

A. Try to define a multi-dimensional array such that we could look up how many items are on a particular floor, within a particular room, and within a particular box.
B. Utilizing only the array defined in part A, how would we print out:
- Number of Floors in the building?
- Number of Rooms on each floor?
- Number of Boxes within each room?
C. Create a method that can return how many items reside on each floor of the building.
D. Create a method that can return how many items reside in each room of a specified floor.
E. Create a method that can return how many items are in the entire building.
F. Define a two-dimensional jagged array which can hold 60 items, where each subsequent sub array holds 10 items more than the last one.

## Primitive Sizes and Byte Buffers

Suppose the following `Datum_Packet` was defined. 

```java
class Datum_Packet
{
	public int     a;
	public double  b;
	public float   c;
	public short   hop_count;
	public boolean encrypted;
	public char    domain_identifier;
}
```

We wish to send this over a network, and want to do so using a byte array. On the other side, when received, the byte array sent will be converted back into a 
`Datum_Packet` on the receiver's side.

A. How big must our byte buffer be to store all the data held within our `Datum_Packet`, as is, without getting too fancy with optimizations?
	- **Hint:** Utilize the size of each primitive type in Java when answering part A.
B. Write code that the sender would utilize to convert a given `Datum_Packet` into a byte array. Use a `ByteBuffer` to assist this conversion.
C. Write code that the receiver would utilize to convert a received byte array into a corresponding `Datum_Packet`. Use a `ByteBuffer` to assist this conversion.

## Exception Handling

Suppose we are given the following input string, and have the following data structure available to capture a limited amount of the input:

``` java
String input = "11x,12y,13,14,cat,15,16,17,18,19";
static int[] array = new int[4];

```

Utilizing a `StringTokenizer`, try to write some code to break up the input into each integer, which we note are comma delimited.

Attempt to handle error checking along the way, consider the following three exceptions at a minimum:

1. `NumberFormatException` - if encountered, move on to the next token
2. `NoSuchElementException` - if encountered, print that something went wrong with the scanner
3. `ArrayIndexOutOfBoundsException` - if encountered, there is no more space in the array to capture input. However, we should print a message to indicate this to the user.
3. `Exception` - if encountered, print a generic exception message

Print out the resulting array when the parsing is done.
