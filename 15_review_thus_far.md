---------------------------
Review Thus Far
---------------------------

## Defining a class

- To create a new class:

```java

class className
{
// zero or more static fields
// zero or more non-static fields
// zero or more constructors
// zero or more methods
}
```

- **Encapsulation:** Tightly-coupling the data with methods is an OOP (object oriented programming) concept. 

## Classes in Java heavily utilize inheritance

- Any class that does not explicitly `extend` a class has a super class of `Object`

## Static vs Non-Static fields

- In java, for static and non-static fields
	- Each field can have
		1. Optional access modifier
			- private - only code within the class can access
			- package - only code in the class or the package can access
			- protected - can be accessed by code in the class and in subclasses of the class
			- public - can be accessed by code in all classes

		2. Optional “static”
			- The same copy of the field is used by all copies of the class versus each instance having it's own copy
		3. Optional “final”
			- The field cannot have it's value changed once it is set
			- Final and static is equivalent to a constant
		4. Required type
			- Primitive type or class type
		5. Optional initial value

## Class Methods

**Constructors**

- Methods with the same name as the class
- Used to construct a new object of the class type
- Do not return a value

**Non constructor methods**

- Functions and subroutines that perform the work associated with the class
- Similar to fields:
	1. Access modifier
		- private
		- package
		- protected
		- public
	2. Optional “static”
	3. Optional “final”
	4. Required return type

**Static methods**

- can be used ***without creating an instance*** of the class
- Example: The `Integer` class has static methods
- `valueOf(int i)`
```java
Integer intValue = Integer.valueOf(10);	
```
- Returns a new `Integer` object
- `parseInt(String s)`
```java
int v = Integer.parseInt(“10”);
```
- Returns `int` representation of a `String`

**Non-statics methods**

- ***require an instance*** of the class to use
- Example: The `Integer` class also has non-static methods
	- `compareTo(Integer otherInteger)`
		- Compares the current `Integer` object to the parameter `Integer` object and returns an `int`

**Overloaded methods**

- Multiple methods within a class having the same name
- The number and types of parameters determines which method to use
- Example: The `String` class has numerous constructors in which the parameters determine which one to use:
	- `String()`
	- `String(byte[] bytesOfTheString)`
	- `String(Bytes[] bytesOfTheString, int startingIndex, int numberOfBytesToUse)`
- The `String` class has multiple `byte[] getBytes()` methods:
	- `byte[] getBytes()`
	- `byte[] getBytes(String characterSetName)`
	- `byte[] getBytes(Charset characterSet)`

## Subclassing

- To create a new subclass:

```java
class subClassName extends superClassName
{
// zero or more static fields
// zero or more non-static fields
// zero or more constructors
// zero or more methods
}
```

- `subClassName` is a ***subclass*** of `superClassName`
- `subClassName` `extends` or ***adds functionality*** to `superClassName`

- `superClassName` is a ***super class*** of `subClassName`
- A subclass ***can only have one super class*** in Java
	- That is, a class can only extend one class
	- We call this ***single inheritance***

## Objects: Creating an instance of a class at runtime

- To create a new object, declare a variable of the object type and then use `new` followed by the class name of the object with the appropriate parameters of the ***constructor*** you want to use. This allocates the object ***on the heap, at run time***.

```java
byte[] b = new byte[] {'a', 'b', 'c'};
String s1 = new String();
String s2 = new String(“abc”);
String s3 = new String(b);
```
- To declare an object, but not instantiate it, leave off the equal sign and everything the the right of it
- Remember that the default value for a non-primitive type in Java is `null`

```java
String s; //this is null by default.
```

## Comparing objects

**Equality operator can be misleading**

- When comparing two objects via the equality operator `==`, it will tell us if two objects are the same object, which is usually not what we want
	- You may have ran into this in programming assignment 2, when trying to compare Strings:
``` java
	String a = "int";
	if(a == "int") //doesn't work, the if equality check would return false.
	if(a.equals("int")) //this will work, the if equals check would return true.	
```

- Unlike primitive types, where `==` does what we expect
	- If the object has an `equals` method, use it.

```java
byte[] b = new byte[] {'a', 'b', 'c'};
String s1 = new String(b);
String s2 = new String("abc");
String s3 = new String("abc");
System.out.println(s1 == s2); 		//prints false
System.out.println(s2 == s3);		//prints false
System.out.println(s1.equals(s2));	//prints true
System.out.println(s2.equals(s3));	//prints true
```

**Defining object equality**

- If you want to support comparing your class to other versions of the class, include an “equals” method which compares the appropriate fields
- For example, if we want to compare two objects of our `Edge` class, we would return true if both edges have the same from and to vertices, and false otherwise
	- We haven't discussed graphs yet, but we will shortly

## Accessing fields and methods of a class

- Suppose we have some `SampleClass`

```java
class SampleClass
{
	public static int publicStaticIntValue = 0;
	public int publicIntValue;
	private int privateIntValue;
	
	SampleClass()
	{
		publicStaticIntValue = publicStaticIntValue+1;
		publicIntValue = 0;
		privateIntValue = 0;
	}
	
	public void setPrivateIntValue(int v)
	{
		privateIntValue = v;
	}
	
	public void setPrivateIntValue(double v)
	{
		privateIntValue = (int) (2.0*v);
	}
	
	public int getPrivateIntValue()
	{
		return privateIntValue;
	}
}
```

And some driver, `testSampleClass`:

```java
class testSampleClass
{
	public static void main(String[] args)
	{
		System.out.println("SampleClass.publicStaticIntValue = " + SampleClass.publicStaticIntValue);
		SampleClass.publicStaticIntValue = -1;
		System.out.println("SampleClass.publicStaticIntValue = " + SampleClass.publicStaticIntValue);
		
		SampleClass sampleClass = new SampleClass();
		System.out.println("SampleClass.publicStaticIntValue = " + SampleClass.publicStaticIntValue);
		
		sampleClass.publicIntValue = 10;
		System.out.println("sampleClass.publicIntValue = " + sampleClass.publicIntValue);
		
		sampleClass.setPrivateIntValue(10);
		System.out.println("sampleClass.getPrivateIntValue() = " + sampleClass.getPrivateIntValue());
		
		sampleClass.setPrivateIntValue(10.0);
		System.out.println("sampleClass.getPrivateIntValue() = " + sampleClass.getPrivateIntValue());
	}
}
```

**Questions about the fields**

Let's focus on the fields:

```java
public static int publicStaticIntValue;
public int publicIntValue;
private int privateIntValue;
```

- Q1: Does `testSampleClass` compile?
- Q2: Why or why not?

**Overloaded methods**
Let's focus on the following overloaded method: 

```java
public void setpPrivateIntValue(int v)
public void setpPrivateIntValue(double v)
```

- Q3: How do we know which will be called in the context of `testSampleClass`?