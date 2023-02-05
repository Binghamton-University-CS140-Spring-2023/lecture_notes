--------------------------------
More Introductory Information
--------------------------------

**The main method - point of entry**
- A java program consists of one or more files, with each file consisting of a `class`, and one of the files containing a method with a signature of
```java
public static void main(String[] args)
```

- When you execute a Java program, the `main` method is the one that is executed by the Java runtime
	- `public` : any code can access it
	- `static` : there is a single copy of it for every occurrence of the class
	- `void`   : there is no return value
	- `String[] args` : the commandline arguments passed to the `main` method as an array of `Strings`

**Types of Variables**

There are four types of variables:

1. ***Instance variables*** – the fields defined in the classes outside of the methods that are associated with each instance of the class. These are non-static fields.
2. ***Class variables*** – fields defined in the classes outside of the methods that are associated with all of the instances of the class. These are static fields, and there is one copy
of the variable in existence, no matter how many copies of the class have been instantiated.
3. ***Local variables*** – these are the variables that are defined within methods and are only visible within the method that they are defined in.
4. ***Parameters*** – these are the variables that are passed to methods, such as `String[] args` in `public static void main(String[] args)`. The may also be called ***arguments***.

- ***Fields*** are the variables associated with a class, other than the local variables and parameters

**Conventions for Naming Variables**
- Variable names are unlimited length sequence of unicode letters and digits
	- They must begin with either a letter, the dollar sign, or the underscore symbol
	- The convention is to begin variable names with letters and not the dollar sign or underscore symbol
	- After the first symbol, they can contain letters, numbers, dollars signs, and
underscore symbols
	- There are keywords and reserved words that cannot be used, for example the keyword `int` cannot be used for a variable name
	- ***Camel case*** is a good choice for variable names
		- The first word is lower case and each subsequent word starts with a capitol letter, such as "ownersLastName”
	- Descriptive variable names are also a good choice

**Conventions for constants**	

- For constants, use `static final`
- utilizing upper case with the underscore symbol between words is common 
- eg, `static final int UPPER_LIMIT = 10;`

**Variable scope**

|Context | Scope |
|------------- | ------------ |
| Class / Instance variables (fields) | available for use ***within the class*** |
| In Static methods | ***only static fields*** are available or in scope |
| In Non-Static methods | ***static and non-static fields*** are available or in scope |
| Local variables | only available or within scope ***in the method they are defined*** |
| Variables defined in enclosing curly brackets "{" and "}" | available or in scope ***within the curly brackets*** |

**Scope Examples**

```java
{
int x = 10;
}
```
- `x` is not defined outside of the brackets


Within a for loop

```java
for( int i = 0; i < 10; i++ )
{
int k = i*10;
System.out.println(“k = “ + k);
}
```
- `i` and `k` are not defined outside of the for loop

**Variable declaration**

- to declare a variable: `Type variableName;`
	- `BankAccount bankAccount;`
	- `int numberOfVertics;`
	
- to declare and initialize a variable: `Type variableName = initial value;`
	- `BankAccount bankAccount = new BankAccount(“smith”, “mary”, “0000”);`
		- When instantiating a new object using a constructor, we use `new` to the left of the constructor signature that we are using
		- this indicates the object will be reside in memory on the heap
	- `int numberOfVertics = 20;`
- When allocating memory for an array we also use `new` to the left of the type name
	- `int[] vertices = new int[10];`
	- `int[] vertices = new int[numberOfVertices];`
	- `BankAcount[] bankAccounts = new BankAccount[10];`
		- This allocates memory for 10 `BankAcount` objects, but does not instantiate any of the objects

**Minor Review**
- We have already covered
	- Looping, if-then, if-then-else, and switch statements
	- Reading from a text file
	- Writing to a text file
	- Reading from a binary file
	- Writing to a binary file
	- Printing to the screen
	- StringTokenizer
	
**Operations**

| Symbol | Operation |
| ------ | --------- |
| `+`  | addition |
| `-`  | subtraction and negation |
| `/`  | division |
| `*`  | multiplication |
| `&&` | logical and |
| `\|\|` | logical or |
| `!`  | logical negation |
| `(` and `)` | praenthesis to group operations or override operation precedence |

**Short circuiting**

- **Note:** Java does lazy evaluation of `||`
	- if the left hand side is ***true***, the whole or statement is true, so the right hand side is not evaluated
```java
boolean result = true || addVertice(node);
```
- Does not execute `addVertice(node)`, since the left hand side of “||” is true

- Similarly, Java does lazy evaluation of `&&`
	- if the left hand side is ***false***, the whole and statement is false, so the right hand side is not evaluated

**Casting primitive types***

- we can cast a primitive type to another by utilzing:
	- `(int)`, `(long)`, `(double)`, `(float)`, `(byte)`, `(char)`, `(short)`

```java
double doubleValue = 25.86329;
int intValue = (int) doubleValue;
```

- Truncates the `double` into an `int`
- Without the cast, the compiler will give a `possibly lossy conversion` error

# General Coding Practices

**Think high level first**

- Before you write your first line of code, think about what data you need, how it is interrelated, and how your program will flow
- Example consideration: Are you reading data from a file or outputting data to a file?
- Try to break your project into bite sized pieces

**Work incrementally to implement the details**

- Write some code
- Test some code
- Think about how you will test/verify that your program is working correctly

**Debugging your code**

- Once you start testing your code, things might not be happening as you expect
- We haven't started using eclipse in the lab, or the debugger yet
- So, what we have to work with is:
	- What you ***think*** your code is doing
	- What your code is ***actually*** doing
	- ***Test data*** that you have created
	- Utilizing `System.out.println()` to figure out what your program is doing
		- At the moment, `System.out.println()`, or writing data to a file, should be your best friend in trying to get your program to work correctly
