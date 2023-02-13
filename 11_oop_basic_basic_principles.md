----------------------------------------------
Object Oriented Programming - Basic Principles
----------------------------------------------

# Classes 

**[What Is a Class?](https://docs.oracle.com/javase/tutorial/java/concepts/class.html)**

- “In the real world, you'll often find many individual objects all of the same kind. There may be thousands of other bicycles in existence, all of the same make and model. Each bicycle was built from the same set of blueprints and therefore contains the same components. In object-oriented terms, we say that your bicycle is an instance of the class of objects known as bicycles. A class is the blueprint from which individual objects are created.”
	
- a ***blue print*** from which we can ***create*** individual ***objects/instances***
- each object has some state information (**fields**)
- each object has some means of being created (**constructor**)
- each object has some means of interacting with the data (**methods**)
	- ***getters***
	- ***setters***
	- `toString()`
	- various others

# Encapsulation - Tightly Coupling Data and Methods

- We can think of a class as a *collection of data* **and** *a collection of methods* to operate on the data
- In object oriented programming, we call this **encapsulation**.
- We call data held in a class `fields` or `member variables`.
- We call functions held in a class `methods`

**Car Example**
- The data can represent something physical
- Suppose we wanted to implement a `Car` class that defines various aspects of a car in the real world.
- Here's some potential data (**fields**) the `Car` class might hold:
	- Fuel capacity 
	- Engine oil capacity
	- Gross vehicle weight
	- Current speed
	- Current gear
	- Fuel burn rate
	- And so on
- And then some potential **methods** that operate on the `Car`'s fields (or state)
	- Change gears
	- Apply the brakes
	- Increase the speed
	- Add fuel
	- And so on	

# BankAccount example

- Let's design a very simple class for a bank account

**BankAcount Fields**

- Our `BankAccount` class needs some attributes
	- First we need to know who the owner of the account is, so how about `String`s for the *owner's last name* and the *owner's first name*
	- Then we probably need an *account number*
	- And also the *current balance* in the **checking account** and also the *current balance* for the **savings account**

- The fields that we will have for the class are:
	- `String ownerLastName`
	- `String ownerFirstName`
	- `String accountNumber`
	- `double checkingBalance` (assume double is accurate enough)
	- `double savingsBalance` (assume double is accurate enough)

**Class modifiers**

- Each of the fields needs to have the appropriate ***modifiers*** applied to them

**Access modifiers**

| Access Modifier | Description |
| --------------- | ----------- |
| `private` | only code within the class can access |
| `default (no keyword)` | also termed **package-private**. only code in the class or the package can access |
| `protected` | can be accessed by code in the class and in subclasses of the class |
| `public` |  can be accessed by code in all classes |

- The access modifier is ***optional*** when declaring each field in the class
- Note: If no access modifier is explictly specified, then the default modifier is utilized. So by default, fields and methods in a class will be considered package-private.

**Applying `static` and `final` keywords to fields**

| Keyword | Description |
| ------- | ----------- |	
| `static` | The same copy of the field is used by all copies of the class versus each instance having it's own copy |
| `final` |  The field cannot have it's value changed once it is set |

- Note: declaring a field as `static final` is equivalent to declaring it a ***constant***
- Note: You may optionally assign an ***initial value*** when declaring a field.
	- For example: ```private static final int DAYS_IN_A_WEEK = 7;```

**Bank Accounts have sensitive data**

- For our initial version of the BankAccount class, `private` seems like the appropriate access modifier
- The state can change for any of these fields, so we opt not to use the `final` keyword
- We want each bank account's state to be unique from another instance of a bank account, so we opt not to use the `static` keyword

```java
class BankAccount
{
private String ownerLastName;
private String ownerFirstName;
private String accountnumber;
private double checkingBalance;
private double savingsBalance;
}
```

**Deciding on our BankAccount constructors**

- We now need 0 or more constructors
	- This is subjective and a design decision we make when developing our class
- In this case, to open a bank account we probably need initial values for *owner name*, *account number* and ***optionally*** the savings and checking *balances* (or $0 by default)
	- This sounds like two ***value constructors***, one having all five fields and one having just three of the fields
	- We can have the three parameter constructor call the five parameter constructor with values of 0 for the two balances
	
## Constructors

```java

BankAccount(String ownerLastName, String ownerFirstName, String accountNumber, 
            double checkingBalance, double savingsBalance)

BankAccount(String ownerLastName, String ownerFirstName, String accountNumber)
```

- Constructors have the ***same name as the class*** and ***do not have a return type***
- The compiler will provide a ***no argument constructor*** for any class without any constructors explicitly defined by the programmer

- Note: The no argument constructor will call the no argument constructor for the super class
	- Here, the ***super class*** refers to the class we `extend` in our current class
	- This will cause an error if the super class does not have a no argument constructor
	- The super class is `Object` unless specified otherwise, which has a no argument constructor	
		- An aside: this is why all classes in java have the `toString()` method we can alter in our class for when we print an instance of the class
		- the `toString()` method is defined in the `Object` class.
		
# Inheritance - (Sub classes and Super classes) 

- We need to take a minute to discuss inheritance, before we continue with the `BankAccount` example, as we started getting into details about the ***super class***.

- **Note:** This is just a high level description of inheritance. We will get into the programming details that Java regarding has later on.

- [What Is Inheritance?](https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html)
	
	- “Different kinds of objects often have a certain amount in common with each other. Mountain bikes, road bikes, and tandem bikes, for example, all share the characteristics of bicycles (current speed, current pedal cadence, current gear). **Yet each also defines additional features that make them different**: tandem bicycles have two seats and two sets of handlebars; road bikes have drop handlebars; some mountain bikes have an additional chain ring, giving them a lower gear ratio.”
	
	- “Object-oriented programming allows classes to inherit commonly used state and behavior from other classes. In this example, Bicycle now becomes the **superclass** of MountainBike, RoadBike, and TandemBike. In the Java programming language, each class is allowed **to have one direct superclass**, and each superclass has the potential for an unlimited number of **subclasses**:”
	
	- “This gives MountainBike all the same fields and methods as Bicycle, yet allows its code to focus exclusively on the features that make it unique. This makes code for your subclasses easy to read. However, you must take care to properly document the state and behavior that each superclass defines, since that code will not appear in the source file of each subclass.”	
	
- **Note:** `final` classes do not allow subclasses
- **Note:** in Java 17 "closed" classes are being looked at, in which a "closed" class may limit what is permitted by subclasses 

# Sealed Classes

- Java 17 has added `sealed` classes, in which a Java class can limit what classes can `extend` it

**Example**

``` java
public **sealed** class BankAccount **permits** EnhancedBankAccount, OtherEnhancedBankAccount
```
- The two classes `EnhancedBankAccount` and `OtherEnhancedBankAccount` can `extend` `BankAccount`, but no other class can `extend` it

**More Info**

- For more information, checkout:
[Java Language Updates - Sealed Classes](https://docs.oracle.com/en/java/javase/15/language/sealed-classes-and-interfaces.html)
[Programming Design Motivation behind Sealed Classes](https://openjdk.java.net/jeps/409)

# Back to the BankAccount Example

**BankAccount methods**
- We now need to add some methods which equate to the operations that a bank account would have
	- Withdraw
	- Transfer
	- Deposit
	- Get the current balance
	- Return the account information

| Method | Description |
| ------------------ | ----------- |
| withdrawFromChecking(double amount) | Withdraw some specified `amount` from checking. |
| withdrawFromSavings(double amount) | Withdraw some specified `amount` from savings. |
| transferFromSavingsToChecking(double amount) | Transfer some specified `amount` from savings to checking |
| transferFromCheckingToSavings(double amount) | Transfer some specified `amount` from checking to savings. |
| depositToSavings(double amount) | Deposit some specified `amount` into savings. |
| depositToChecking(double amount) | Deposit some specified `amount` into checking. |
| toString() | Return the account information in some string representation of the held state. |

**More decisions for the BankAccount Methods**

- For the `withdraw` and `transfer` methods, we can return a `boolean` if there is not sufficient money to perform the operation

- Like the fields of the class, these methods can also have access modifiers
	- `public`, `private`, `default` (package-private), `protected`
	
- Methods can also be `static`, which means ***you do not need a copy of the object to access the method***
	- public static void main(String[] args)
	- We don't need to create a copy of the class to execute the main method
	- In contrast, we need some instance of `BankAccount` to interact with, so we opt not to utilize static methods with the `BankAccount` class.
	
- **Return types:** 
- Return type can be void or a valid class or primitive type

**BankAccount's Accessor Methods**

- We also need some accessor methods (getters)

|Access Method | Description |
| ------------ | ----------- | 
| getOwnerLastName() | Returns the owner's last name of the bank account. |
| getOwnerFirstName() | Returns the owner's first name of the bank account. |
| getAccountNumber() | Return the account number of the bank account. |
| getSavingsBalance() | Returns the savings balance of the bank account. |
| getCheckingBalance() | Returns the checking balance of the bank account. |
 
 **Generating unique BankAccount numbers - leveraging a static int**
 
 - Let's leverage utilizing a static int within the class to implicitly assign
 a unique bank account number to each `BankAccount` object we construct.
 
 - Let's add a `public static int` to the class, which will count how many objects have been created
	- declare the field: `public static int objectCount = 0;` 
	- Each time the construct is called, we increment: `objectCount = objectCount+1;`
- This will give us a count of the number of `BankAccount` objects we have constructed in our program
- We could also use this to automatically generate the  `accountNumber` when an instance of the class is instantiated

# The EnhancedBankAccount class - Our first example of subclassing 

- Now that we have a partially functional `BankAccount` class, let's create a new class that is an ***extension*** of the `BankAccount` class
- The new class will be `EnhancedBankAccount`
	- We will add functionality to keep track of all transactions
	- Add ArrayLists for:
		- All deposits
		- All withdrawals
		- All transfers
		
- We can **inherit** the ***existing functionality*** of `BankAccount`, and just add the ***new functionality*** to `EnhancedBankAccount`
- To track the transactions, we will add and leverage a class that has three fields, the *type of transaction*, the *date of the transaction*, and the *amount of the transaction*
- And then we need methods to get the lists of transactions

# Importing

- To import a `package` or `class`:
	- add `import` followed by the package or class path 
	- once done, you do not need to use the full path for the class throughout your code

**Example**

- We can add `import java.util.ArrayList` in `EnhancedBankAccount` 
	- prior to the where we declare the `class`
	- Now we can use `private ArrayList<Transaction> savingsDepositTransactions;`
	-  instead of `private java.util.ArrayList<Transaction> savingsDepositTransactions;`
	
**Here's the Bank Account code - thus far**

- `BankAccount.java`

```java
class BankAccount
{
	private final String ownerLastName;
	private final String ownerFirstName;
	private final String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int bankAccountCount = 0;
	
	BankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = makeAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
		bankAccountCount = bankAccountCount+1;
	}
	
	BankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		return false;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		return false;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		return false;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		return false;
	}
	
	public void depositToSavings(double amount)
	{
	}
	
	public void depositToChecking(double amount)
	{
	}
	
	public String toString()
	{
		return "";
	}
	
	public String getOwnerLastName()
	{
		return "";
	}
	
	public String getOwnerFirstName()
	{
		return "";
	}
	
	public String getAccountNumber()
	{
		return "";
	}
	
	public double getCheckingBalance()
	{
		return 0.0;
	}
	
	public double getSavingsBalance()
	{
		return 0.0;
	}
	
	private String makeAccountNumber()
	{
		String aNumber = "" + bankAccountCount;
		
		while( aNumber.length() < 6 )
		{
			aNumber = "0" + aNumber;
		}
		return aNumber;
	}
	
	public static int getBankAccountCount()
	{
		return bankAccountCount;
	}
}
```

- `EnhancedBankAccount.java` 

``` java
import java.util.ArrayList;
import java.util.Date;

class EnhancedBankAccount extends BankAccount
{
	private ArrayList<Transaction> successfulTransactions;
	private ArrayList<Transaction> failedTransactions;
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		super(ownerLastName, ownerFirstName, checkingBalance, savingsBalance);
		
		successfulTransactions = new ArrayList<>();
		failedTransactions = new ArrayList<>();
	}
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		return false;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		return false;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		return false;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		return false;
	}
	
	public void depositToSavings(double amount)
	{
	}
	
	public void depositToChecking(double amount)
	{
	}
	
	public ArrayList<Transaction> getAllSuccessfulTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getAllFailedTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsDepositTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	private ArrayList<Transaction> getTransactions(TransactionType transactionType)
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingDepositTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsWithdrawalTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingWithdrawalTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsToCheckingTransferTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingToSavingsTransferTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getFailedTransactions(Date startDate, Date endDate)
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSuccessfulTransactions(Date startDate, Date endDate)
	{
		return new ArrayList<Transaction>();
	}
}
```

- `Transaction.java`

``` java
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

- The code compiles
- Note there is very limited functionality
