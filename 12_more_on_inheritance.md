--------------------------------------
More on Inheritance
--------------------------------------

**Modifications to EnhancedBankAccount**

- Let's make a few minor changes to our `EnhancedBankAccount`
- Instead of having a seperate transaction list for each type of transaction, let's have:
	- one for ***successful*** transactions and 
	- one for ***failed*** transactions
- To support this, we will update the `Transaction` class to have three fields:
	- one for the ***type of transaction***,
	- one for the ***date***, and 
	- one for the ***amount***
- And for the date, we will use `java.util.Date` instead of the `String` representation of the date
	- **Note:** `java.time.LocalDate` is also an option


**Modifications to the Transacation class**

```java
class Transaction
{
	final private TransactionType type;
	final private java.util.Date date;
	final private double amount;
	
	Transaction(TransactionType type, java.util.Date date, double amount)
	{
		this.type = type;
		this.date = date;
		this.amount = amount;
	}
	
	public java.util.Date getDate()
	{
		return date;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public TransactionType getType()
	{
		return type;
	}
	
	public String toString()
	{
		return type.name() + " " + date.toString() + " " + amount;
	}
}
```

- We replace the six `ArrayLists` with the following two:
	- `private java.util.ArrayList<Transaction> successfulTransactions;`
	- `private java.util.ArrayList<Transaction> failedTransactions;`
- So our new EnhancedBankAccount is initially

```java
class EnhancedBankAccount extends BankAccount
{
	private java.util.ArrayList<Transaction> successfulTransactions;
	private java.util.ArrayList<Transaction> failedTransactions;
}
```

**Subclassing via the `extends` keyword**

- The `extends BankAccount` means `EnhancedBankAccount` is a ***subclass*** of `BankAccount`
	- It is a subclass because it is a ***specialization*** of the more general `BankAccount`
	- `EnhancedBankAccount` ***inherits*** the fields and methods of `BankAccount`

- At the same time, `BankAccount` is a ***superclass*** of `EnhancedBankAccount`
	- The subclass or ***child class*** inherits from another class
	- The superclass or ***parent class*** is inheritted from
- Java supports single inheritence of classes
	- That is, a class can **extend one class and *only* one class.**
	- This differs from say c++, which does allow mult-inheritance
		- this gives rise to what is known as the [diamond problem](https://www.makeuseof.com/what-is-diamond-problem-in-cpp/)
		- [java was designed to avoid the diamond problem](https://www.makeuseof.com/what-is-diamond-problem-in-cpp/)

**Using the `final` keyword to prohibt inheritance**	

- We can apply the `final` access modifier to a ***class***, and then the class does not allow any subclasses
- `final EnhancedBankAccount` would mean that there could be no subclasses of `EnhancedBankAccount`

# Subclassing in a bit more detail

[From the Java Tutorials:](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)

- *Definitions:* 
- A class that is derived from another class is called a ***subclass*** (also a ***derived class***, ***extended class***, or ***child class***). 
- The class from which the subclass is derived is called a ***superclass*** (also a ***base class*** or a ***parent class***).
- Except for `Object`, which has no superclass, every class has one ***and only one*** direct superclass (***single inheritance***). 
- In the absence of any other explicit superclass, every class is ***implicitly a subclass of `Object`***.
– Classes can be derived from classes that are derived from classes that are derived from classes, and so on, and ultimately derived from the topmost class, `Object`.
- Such a class is said to be ***descended*** from all the classes in the inheritance chain stretching back to `Object`.

**Motivation - maximize code reuse**

- The idea of inheritance is simple but powerful: When you want to create a new class and there is already a class that includes some of the code that you want, you can ***derive your new class from the existing class***. In doing this, you can ***reuse the fields and methods*** of the existing class without having to write (and debug!) them yourself.
- A subclass inherits all the members (fields, methods, and nested classes) from its superclass. - **Note:** Constructors are special and not considered members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.

**Inherited members - Based on access modifiers in the parent**

- A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. 
- If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. 
- A subclass does not inherit the private members of its parent class. 
	- However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.

## Extendability - using inherited members but also adding functionality in the child class
	
- You can use the inherited members as is, replace them, hide them, or supplement them with new members:
- The inherited fields can be used directly, just like any other fields.
- You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
- You can declare new fields in the subclass that are not in the superclass.
- The inherited methods can be used directly as they are.
- You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus ***overriding*** it.
	- we have done this already, with the `toString()` method, which is inherited from the `Object` class
- You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
- You can declare new methods in the subclass that are not in the superclass.
- You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword `super`.

**Caveats of Inheritance regarding nested classes**

- [A nested class is a class defined within a class](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
- A nested class has access to all the private members of its enclosing class, both fields and
methods. 
- Therefore, a public or protected nested class inherited by a subclass has indirect access to all of the private members of the superclass.


# Casting objects

**Upcasting (a BlueJay is a Bird)**

- Suppose we have constructed some `EnhancedBankAccount` object:
	- `EnhancedBankAccount eba = new EnhancedBankAccount(“smith”, “mary”, “0000”);`

- Since `eba` is an `EnhancedBankAccount` and `EnhancedBankAccount` is descended from `BankAccount` and `BankAccount` is descended from `Object`, we can ***cast*** `eba` as a `BankAccount` or an `Object`.

```java
BankAccount ba = new EnhancedBankAccount(“smith”, “mary”, “0000”);
Object oobj = new EnhancedBankAccount(“smith”, “mary”, “0000”);
Object obj = (Object) eba;
BankAccount ba = (Object) eba;
```

- when we cast from a subclass **up** to some parent class, we call this **upcasting**
	- upcasting is always safe
	- upcasting goes from a more specific type to a less specific type

**Downcasting (but a Bird is not necessarily a BlueJay)**

- The reverse is not true. We cannot arbitrarily cast any `Object` or `BankAccount` into a `EnhancedBankAccount`

- Consider the following example: 

```java
Object problematic = new Object();
Object obj = new EnhancedBankAccount(“smith”, “mary”, “0000”);
EnhancedBankAccount eba = obj; //compilation error about incompatible types
EnhancedBankAccount eba = (EnhancedBankAccount) obj; //downcast, in this case valid.
EnhancedBankAccount eba = (EnhancedBankAccount) problematic; //downcast, in this case will cause a runtime error `java.lang.ClassCastException`
```
- The first assignment, where we try to set some `EnhancedBankAccount` object (`eba`), to some `Object` (`obj`), will result in a will result in a ***compilation error.*** 

- The second line, where we try to cast `obj` to an `EnhancedBankAccount`, is called a ***downcast***, and will compile.
- Downcasting is when we cast from a parent class **down** to some child class.

- However, at run time two things can occur:
	- the cast is successful, in which case execution carries on just fine
	- the cast is unsuccessful, resulting in a runtime error
	- the result is dictated by whether the object being downcasted is an `instanceof` the subclass to which it is being casted
- We can use `instanceof` to verify that `obj` is of type `EnhancedBankAccount` prior to casting it:

```java
if( obj instanceof EnhancedBankAccount)
{
	EnhancedBankAccount eba = (EnhancedBankAccount) obj;
}
```

# Polymorphism - dynamic dispatching

- Inheritance has one more powerful feature built in, called ***polymorphism***
- When we ***override*** some method that has been inherited from our parent class,
we are specializing the behavior for that function.
- Additionally, objects have a static type and a dynamic type.
- The static type is what we say the type is when we define the variable.
- The dynamic type is equal to what we have constructed the value to be on the heap, using the new keyword.
-Consider the following example with Birds:

``` java
class Bird
{	
	protected String m_name;
	
	public Bird(String name)
	{
		m_name = name;
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Bird)";
	}
	
	public void sing()
	{
		System.out.println("Who knows what the mystery bird sings?");
	}
}

class BlueJay extends Bird
{
	public BlueJay(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (BlueJay)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("BlueJays sing the blues.");
	}
}

class Canary extends Bird
{
	public Canary(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Canary)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("Canaries tweet happily.");
	}
}

class Cardinal extends Bird
{
	public Cardinal(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Cardinal)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("Cardinals enjoy the classical.");
	}
}

class BirdHouse
{	
	public static void main(String[] args)
	{
		java.util.List<Bird> birdList = new java.util.ArrayList<>();
		birdList.add(new Bird("Lester"));
		birdList.add(new BlueJay("Gerald"));
		birdList.add(new Canary("Henry"));
		birdList.add(new Cardinal("Alice"));
	
		System.out.println("=====================================");
		System.out.println("         Dynamic dispatching         ");
		System.out.println("=====================================");
		for(Bird bird : birdList)
		{
			System.out.println(bird);
			bird.sing();
			System.out.println("*******************************");
		}
		
		System.out.println("\n\n=====================================");
		System.out.println("           Is a Relationship             ");
		System.out.println("=========================================");
		for(Bird bird : birdList)
		{
			System.out.println(bird);
			System.out.println("class name:    " + bird.getClass().getName());
			System.out.println("Is an Object:  " + (bird instanceof Object));		
			System.out.println("Is a Bird:     " + (bird instanceof Bird));
			System.out.println("Is a Bluejay:  " + (bird instanceof BlueJay));
			System.out.println("Is a Cardinal: " + (bird instanceof Cardinal));
			System.out.println("Is a Canary:   " + (bird instanceof Canary));
			System.out.println("*******************************");
		}
	}
}
```

- We see that the instance method called will be dictated by the object's dynamic type, not its static type.

# Records

- [Records were introduced in Java 14](https://docs.oracle.com/en/java/javase/14/language/records.html)
- “It’s ideal for "plain data carriers," classes that contain data not meant to be altered and only the most fundamental methods such as constructors and accessors.”
- The transaction class reduces to

```java
record Transaction(TransactionType type, java.util.Date date, double amount)
{
	public String toString()
	{
		return type.name() + " " + date.toString() + " " + amount;
	}
}
```

- And using it:

```java
class testTransaction
{
	public static voic main(String[] args)
	{
		Transaction t = new Transaction(TransactionType.DEPOSIT, new java.util.Date(), 10.0);
		
		System.out.println("t.toString() = " + t.toString());
		
		System.out.println("t.type() = " + t.type());
		System.out.println("t.date() = " + t.date());
		System.out.println("t.amount() = " + t.amount());
	}
}
```
