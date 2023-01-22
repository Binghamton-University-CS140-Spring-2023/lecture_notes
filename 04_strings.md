**The following is from the Java tutorial**

<a href="https://docs.oracle.com/javase/tutorial/java/concepts/class.html" target="blank">Tutorial</a>

- What is a Class?
  - "In the real world, you'll often find many individual objects all of the same kind. There may be thousands of other bicycles in existence, all of the same make and model. Each bicycle was built from the same set of blueprints and therefore contains the same components. In object-oriented terms, we say that your bicycle is an instance of the class of objects known as bicycles. A class is the blueprint from which individual objects are created.""
- And an object is an *instance* of a class
- The following Bicycle class is one possible implementation of a bicycle:

```java
class Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" +
             speed + " gear:" + gear);
    }
}
```

**Java String class**
- A String is a sequence of characters
- In Java, Strings are objects or *instances* of the `String` class
- `String` literals in Java programs are implemented as *instances* of the String class
such as

```java
String s = “abcd”;
```
- This creates a new `String` object representing the string "abcd"
- Take a look at the <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html" target="blank">Java documentation for String</a>
- Java has numerous constructors for the `String` class
  - `String()`, construct a `String` representing the empty character sequence
  - `String(byte[] bytes)`, construct a new `String` consisting of the bytes in the `byte` array `bytes`
  - `String(char[] chars)`, construct a new `String` consisting of the characters of the character array `chars`
  - `String("abcd")`
  - There are plenty more
- Strings are immutable or constant, so any changes you make to an existing `String` will create a new `String`
- Strings can be shared, in theory there should be a single copy of any `String` in your program, but don't count on it if they are created dynamically during the running of the program. There is a separate memory area "String space" and the `intern()` method returns a shared copy that is put into the "String space"
- The class `String` also has numerous methods
- Getting a `byte` array for the bytes in the `String`
- Getting a `char` array for the characters in the `String`
- Changing the case
- Converting various primitive types to a `String`
- The "+" sign can be used for concatenation
- `"abc" + "def"` is the `String` `"abcdef"`
- `StringBuilder` and `StringBuffer`
- `StringBuffer` is thread safe and is a mutable sequence of characters
- `StringBuilder` is API compatible with `StringBuffer`, but it not thread safe
- Should be faster than `StringBuffer` in single-thread applications
