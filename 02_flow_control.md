**Instruction Flow**
- Programs have methods (also called functions in many programming languages)
- The statements in a method generally are executed in the order that they are written, from the top of the method to the bottom of the method
- Flow control statements allow us to change this behavior

**Flow control statements**
- Conditional statements
  - `if`
  - `switch`
- Loop statements
  - `for`
  - `while`
  - `do-while`
- Branch statements
  - `break`
  - `continue`
  - `return`
- All of these statement names are lowercase, if the first letter of any of these statements is capitalized in the slides it is a mistake

**if statement**
- The if-then and if-then-else statements can be used to conditionally execute a block of statements based on a boolean test
  - if-then statement

```
if(boolean test) {
  // block of statements to execute if the boolean test is true
}
```

- Example
- Assume that an integer `x` has been previously defined and set to a value

```java
if(x == 20) {
  System.out.println(“the value of x is 20”);
}
```

- In the above, if the value of `x` is 20, then the boolean test is `true`, and the block of statements contained within the “{“ and “}” are executed (“the value of x is 20” is printed to the screen)
- If the value of `x` is not 20, then the boolean test is `false`, and the block of statements contained within the “{“ and “}” are not executed (“the value of x is 20” is not printed to the screen)
- if-then-else statement

```
if(boolean test) {
  // block of statements to execute if the boolean test is true
} else {
  // block of statements to execute if the boolean test is false
}
```

- For the if-then-else statement, since there is a case when the  boolean is `true` (then case) or `false` (else case), one of the blocks of statements is going to be executed
- Example
- Assume that an integer `x` has been previously defined and set to a value

```java
if(x == 20) {
  System.out.println(“the value of x is 20”);
} else {
  System.out.println(“the value of x is not 20”);
}
```

- If the value of `x` is 20, the boolean test is `true`, and the block of statements contained in the “{“ and “}” prior to the else statement are executed (“the value of x is 20” is printed to the screen)
- If the value of `x` is not 20, then the boolean test is false, and the block of statements contained in the “{“ and “}” after the else statement are executed (“the value of x is not 20” is printed to the screen)
- if-then-else statements can be nested to handle multiple cases
Example
- Assume that an integer `x` has been previously defined and set to a value

```java
if(x <= 20) {
  System.out.println(“the value of x is less than equal to 20”);
} else {
  if(x == 21) {
    System.out.println(“the value of x is 21”);
  } else {
    if(x == 22) {
      System.out.println(“the value of x is 22”);
    } else {
      System.out.println(“the value of x is greater than 22”);
    }
  }
}
```

- Java likes to collapse this form of the conditional sequence and call it the if-else if with optional else statement

```java
if(x <= 20) {
  System.out.println("the value of x is less than equal to 20");
} else if(x == 21) {
  System.out.println(“the value of x is 21”);
} else if(x == 22) {
  System.out.println(“the value of x is 22”);
} else {
  System.out.println(“the value of x is greater than 22”);
}
```

**The switch statement**
- The switch statement can have a number of execution paths. Can work with `byte`, `short`, `char`, and `int` types. Can also work with enumerated types (will discuss eventually), `String`, and the wrapper classes `Character`, `Byte`, `Short`, and `Integer`. There are other extensions being tried in Java 17.

```java
public class Flow1 {
  public static void main(String[] args) {		
    int testValue = Integer.parseInt(args[0]);
    switch(testValue) {
    case 1:
      System.out.println("case with testValue is 1");
      System.out.println("here's a second line");
    case 2:
      System.out.println("case with testValue is 2");
    case 3:
      System.out.println("case with testValue is 3");
      System.out.println("here's a second line");
      System.out.println("here's a third line");
    default:
      System.out.println("default case");
    }
  }
}
```

- In this example, once we get a case that matches, we execute everything that follows (we "fall-through" into all the remaining cases), which is probably not what we wanted. The default case is executed if there is no match in any of the cases.
- OUTPUT

```
> java Flow1 1
case with testValue is 1
here's a second line
case with testValue is 2
case with testValue is 3
here's a second line
here's a third line
default case
> java Flow1 2
case with testValue is 2
case with testValue is 3
here's a second line
here's a third line
default case
> java Flow1 3
case with testValue is 3
here's a second line
here's a third line
default case
> java Flow1 5
default case
```

- Example of the more typical use of switch, where "break" prevents the "fall-through"

```java
public class Flow2 {
  public static void main(String[] args) {		
    int testValue = Integer.parseInt(args[0]);
    switch(testValue) {
    case 1:
      System.out.println("case with testValue is 1");
      System.out.println("here's a second line");
      break;
    case 2:
      System.out.println("case with testValue is 2");
      break;
    case 3:
      System.out.println("case with testValue is 3");
      System.out.println("here's a second line");
      System.out.println("here's a third line");
      break;
    default:
      System.out.println("default case");
    }
  }
}
```

- OUTPUT

```
> java Flow2 1
case with testValue is 1
here's a second line
> java Flow2 2
case with testValue is 2
> java Flow2 3
case with testValue is 3
here's a second line
here's a third line
> java Flow2 5
default case
```

- Example using integer

```java
public class Flow3 {
  public static void main(String[] args) {		
    Integer testValue = Integer.valueOf(args[0]);
    switch(testValue) {
    case 1:
      System.out.println("case with testValue is 1");
      System.out.println("here's a second line");
      break;
    case 2:
      System.out.println("case with testValue is 2");
      break;
    case 3:
      System.out.println("case with testValue is 3");
      System.out.println("here's a second line");
      System.out.println("here's a third line");
      break;
    default:
      System.out.println("default case");
    }
  }
}
```

- The output is the same as the one above with Flow2 replaced by Flow3
- Normally the default: is written last but that is not required for example: Flow2 could be rewritten:

```java
public class Flow2 {
  public static void main(String[] args) {		
    int testValue = Integer.parseInt(args[0]);
    switch(testValue) {
    case 1:
      System.out.println("case with testValue is 1");
      System.out.println("here's a second line");
      break;
    default:
      System.out.println("default case");
      break;
    case 3:
      System.out.println("case with testValue is 3");
      System.out.println("here's a second line");
      System.out.println("here's a third line");
      break;
    case 2:
      System.out.println("case with testValue is 2");
    }
  }
}
```

- An example using Strings

```Java
public class Flow4 {
  public static void main(String[] args) {		
		String testValue = args[0];
		switch(testValue.toUpperCase()) {
		case "ONE":
			System.out.println("case with testValue is " + testValue + " (1)");
			System.out.println("here's a second line");
			break;
		case "THREE":
			System.out.println("case with testValue is " + testValue + " (3)");
			System.out.println("here's a second line");
			System.out.println("here's a third line");
			break;
		case "TWO":
			System.out.println("case with testValue is " + testValue + " (2)");
			break;
		default:
			System.out.println("default case");
		}
  }
}
```

- OUTPUT

```
> java Flow4 Three
case with testValue is Three (3)
here's a second line
here's a third line
> java Flow4 three
case with testValue is three (3)
here's a second line
here's a third line
```

**Loops**
- There are for loops, enhanced for loops, while loops and do-while loops.
- `while` loop

```
while(boolean expression) {
  Block of statements to execute
}

```

- Example

```java
boolean done = false;
while(!done) {
  statements
}
```

- do-while is similar except the boolean is evaluated at the end of the first execution of the block of statements, ensuring at least one execution of this loop body.
- This is the only compound Java statement that ends in a semicolon

```java
boolean done = false;
do {
  statements
} while(!done);
```

- Example of do-while. It is not typical to modify the control variable in the `while` test expression but this does show how ++i and i++ work differently:

```Java
public class Flow5 {
  public static void main(String[] args) {		
		int upperLimit = Integer.parseInt(args[0]);
		System.out.println("using \"do-while(i++ < upperLimit)\"");
		int i = 0;
		do {
			System.out.println("i = " + i);
		} while (i++ < upperLimit);
		System.out.println();
		System.out.println("using \"do-while(++i < upperLimit)\"");
		i = 0;
		do {
			System.out.println("i = " + i);
		} while (++i < upperLimit);
  }
}
```

- OUTPUT

```
> java Flow5 3
using "do-while(i++ < upperLimit)"
i = 0
i = 1
i = 2
i = 3

using "do-while(++i < upperLimit)"
i = 0
i = 1
i = 2
```

**Branch statements in loops**

**Break statement in for, while, do-while loops**
- We have seen the `break` statement using in the switch statement.
- Here it is used in the for loop with a counter (it will also work in an enhanced for loop), in a while loop and in a do-while loop:

```Java
public class Flow6 {
  public static void main(String[] args) {		
		System.out.println("for loop with a break when i is 3");
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			if(i == 3) break;
		}

		System.out.println("\nwhile loop with a break when i is 3");
		int i = 0;
		while(i < 10) {
			System.out.println("i = " + i);
			if(i == 3) break;
			i++;
		}

		System.out.println("\ndo-while loop with a break when i is 3");
		i = 0;
		do {
			System.out.println("i = " + i);
			if(i == 3) break;
			i++;
		} while(i < 10);
  }  
}
```

- OUTPUT

```
for loop with a break when i is 3
i = 0
i = 1
i = 2
i = 3

while loop with a break when i is 3
i = 0
i = 1
i = 2
i = 3

do-while loop with a break when i is 3
i = 0
i = 1
i = 2
i = 3
```

- The `break` can be followed by a label that is attached to a loop. Note that control doesn't transfer back to the label, rather the `break` terminates the loop associated with the label:

```Java
public class Flow7 {
  public static void main(String[] args) {		
		System.out.println("nest loop with a labelled break");
		outerLoopLabel:
			for(int i = 0; i < 3; i++) {
				System.out.println("i = " + i);
				for(int j = 0; j < 4; j++) {
					System.out.println("\tj = " + j);
					if(j == 2) break outerLoopLabel;
				}
			}

		System.out.println("COMPARE");
		System.out.println("loop with a simple break");
		for(int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 4; j++) {
				System.out.println("\tj = " + j);
				if(j == 2) break;
			}
		}

		System.out.println("ALSO");
		System.out.println("3 nested loops with a label on middle loop");
		for(int k = 0; k < 2; k++) {
			System.out.println("k = " + k);
			middleLoop:
				for(int i = 0; i < 3; i++) {
					System.out.println("\ti = " + i);
					for(int j = 0; j < 4; j++) {
						System.out.println("\t\tj = " + j);
						if(j == 2) break middleLoop;
					}
				}
		}
}
```

- OUTPUT

```
nest loop with a labelled break
i = 0
	j = 0
	j = 1
	j = 2
COMPARE
loop with a simple break
i = 0
	j = 0
	j = 1
	j = 2
i = 1
	j = 0
	j = 1
	j = 2
i = 2
	j = 0
	j = 1
	j = 2
ALSO
3 nested loops with a label on middle loop
k = 0
	i = 0
		j = 0
		j = 1
		j = 2
k = 1
	i = 0
		j = 0
		j = 1
		j = 2
```

**Continue statement in for, while, do-while loops**
- The `continue` statement skips the rest of the loop it appears in and jumps to the starts of the next iteration
- Note: the incrementing of “i” is moved before the continue statement to avoid an infinite loop in the for the while and do-while loops. This causes a change in the initial value and upper bound of the loops.

```java
public class Flow8 {
  public static void main(String[] args) {		
		System.out.println("for loop with a continue when i is 1");
		for(int i = 0; i < 4; i++) {
			if(i == 1) continue;
			System.out.println("i = " + i);
		}

		System.out.println("\nwhile loop with a continue when i is 1");
		int i = -1;
		while(i < 3) {
			i++;
			if(i == 1) continue;
			System.out.println("i = " + i);
		}

		System.out.println("\ndo-while loop with a continue when i is 1");
		i = -1;
		do {
			i++;
			if(i == 1) continue;
			System.out.println("i = " + i);
		} while(i < 3);
	}
}
```

- OUTPUT

```
for loop with a continue when i is 1
i = 0
i = 2
i = 3

while loop with a continue when i is 1
i = 0
i = 2
i = 3

do-while loop with a continue when i is 1
i = 0
i = 2
i = 3
```

- The `continue` statement can also have a label

```java
public class Flow9 {
  public static void main(String[] args) {		
		System.out.println("nest loop with a labelled continue");
		outerLoopLabel:
			for(int i = 0; i < 5; i++) {
				System.out.println("i = " + i);
				for(int j = 0; j < 3; j++) {
					if(j == 1) continue outerLoopLabel;
					System.out.println("\tj = " + j);
				}
			}

		System.out.println("loop with a simple continue");
		for(int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 3; j++) {
				if(j == 1) continue;
				System.out.println("\tj = " + j);
			}
		}

		System.out.println("ALSO");
		System.out.println("3 nested loops with a label on middle loop");
		for(int k = 0; k < 2; k++) {
			System.out.println("k = " + k);
			middleLoop:
				for(int i = 0; i < 5; i++) {
					System.out.println("\ti = " + i);
					for(int j = 0; j < 3; j++) {
						if(j == 1) continue middleLoop;
						System.out.println("\t\tj = " + j);
					}
				}
		}
  }
}
```

- OUTPUT

```
nest loop with a labelled continue
i = 0
	j = 0
i = 1
	j = 0
i = 2
	j = 0
i = 3
	j = 0
i = 4
	j = 0
loop with a simple continue
i = 0
	j = 0
	j = 2
i = 1
	j = 0
	j = 2
i = 2
	j = 0
	j = 2
i = 3
	j = 0
	j = 2
i = 4
	j = 0
	j = 2
ALSO
3 nested loops with a label on middle loop
k = 0
	i = 0
		j = 0
	i = 1
		j = 0
	i = 2
		j = 0
	i = 3
		j = 0
	i = 4
		j = 0
k = 1
	i = 0
		j = 0
	i = 1
		j = 0
	i = 2
		j = 0
	i = 3
		j = 0
	i = 4
		j = 0
```

**Branch statement using return**
- This only has an effect inside a method, which we discuss at length soon
- The return statement immediately ends the execution the method and return to the place where the method was called
- If the method is a void method we write `return;`
- If the method returns a value, we will write `return x;` where x is an appropriate value.

**The return statement can make an else redundant**
- This is actually bad style:

```Java
if(x > 0) {
  System.out.println("x is positive");
  return 1.0/x;
} else {
  System.out.println("x is negative");
  return -1.0/x;  
}
```

- The code that shows you understand how the program flow works is:

```Java
if(x > 0) {
  System.out.println("x is positive");
  return 1.0/x;
}
System.out.println("x is negative");
return -1.0/x;  
```
