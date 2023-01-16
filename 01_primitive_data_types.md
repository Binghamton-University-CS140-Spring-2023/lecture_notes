<!--https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet
https://stackoverflow.com/questions/35465557/how-to-apply-color-in-markdown-->


-----------------------------
**CS 140 Programming with Objects and Data Structures**

-----------------------------

**Java has the following primitive data types**
- Primitive data types are built into the Java language and are *not* objects
- `byte` 8 bit signed two's complement integer, can store numbers in the range -128 to 127 [-2<sup>7</sup>, 2<sup>7</sup>-1]
- `short` 16 bit signed two's complement integer, can store numbers in the range -32,768 to 32,767 [-2<sup>15</sup>, 2<sup>15</sup>-1]
- `int` 32 bit signed two's complement integer, can store numbers in the range -2,147,483,648 to 2,147,483,647 [-2<sup>31</sup>, 2<sup>31</sup>-1]
- `long` 64 bit signed two's complement integer, can store numbers in the range  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 [-2<sup>63</sup>, 2<sup>63</sup>-1]
- `float` 32 bit IEEE 754 floating point number, see <a href="https://en.wikipedia.org/wiki/IEEE_754-1985" target="blank">IEEE 754-1985</a>, although <a href="https://www.baeldung.com/java-primitives" target="blank">Baeldung</a> gives other values.
- `double` 64 bit IEEE 754 floating point number
- `boolean` X bytes in size (there is only one bit of information, and the actual size seems to be JVM dependent), store a value of true or false
- `char` 16 bit Unicode character, \u0000 to \uffff [0, 2<sup>16</sup>-1]
- Reminder, 1 `byte` consists of 8 `bits` with each bit being either 0 or 1. This <a href="
https://openjdk.java.net/projects/valhalla/design-notes/in-defense-of-erasure" target="blank">reference about generics</a> mentions that boolean, byte, char, short are processed as int in the Java Virtual Machine.

**Common usage**
- The `int` type is typically what is used for integer variables
- Smaller integer types, byte and short may be used in embedded computer applications to save memory. Also we will see the use of byte-arrays later, which are more compact than integer-arrays.
- The byte-arrays can be used to generate ASCII Strings.
- Obviously use long when an int does not have the required range of values (for example the factorial of 13)
- The Thread.sleep() method takes a long parameter for the number of milliseconds to sleep and
System.currentTimeMillis() returns a long--is this the total number of milliseconds since the start of January 1, 1970 up to the time in your computer at the moment of the call. The maximum value is in the year 292,278,994.
- When using floating-point numbers we almost always use the 64-bit `double` type.
- Java integer values can be initialized using:
  - decimal (base 10)
  - hexadecimal (base 16, '0x' prefix)
  - octal (base 8, '0' prefix)
  - binary (base 2, '0b' prefix)

```java
public class Primitives1 {
  public static void main(String[] args) {
    long longDec = 10;
    long longHex = 0xa;
    long longOct = 012;
    long longBin = 0b00001010;

    int intDec = -10;
    int intHex = -0xa;
    int intOct = -012;
    int intBin = -0b00001010;

    short shortDec = 10;
    short shortHex = 0xa;
    short shortOct = 012;
    short shortBin = 0b00001010;

    byte byteDec = -10;
    byte byteHex = -0xa;
    byte byteOct = -012;
    byte byteBin = -0b00001010;

    System.out.println("longDec = " + longDec);
    System.out.println("longHex = " + longHex);
    System.out.println("longOct = " + longOct);
    System.out.println("longBin = " + longBin);

    System.out.println("intDec = " + intDec);
    System.out.println("intHex = " + intHex);
    System.out.println("intOct = " + intOct);
    System.out.println("intBin = " + intBin);

    System.out.println("shortDec = " + shortDec);
    System.out.println("shortHex = " + shortHex);
    System.out.println("shortOct = " + shortOct);
    System.out.println("shortBin = " + shortBin);

    System.out.println("byteDec = " + byteDec);
    System.out.println("byteHex = " + byteHex);
    System.out.println("byteOct = " + byteOct);
    System.out.println("byteBin = " + byteBin);
  }
}
```

- OUTPUT

```
longDec = 10
longHex = 10
longOct = 10
longBin = 10
intDec = -10
intHex = -10
intOct = -10
intBin = -10
shortDec = 10
shortHex = 10
shortOct = 10
shortBin = 10
byteDec = -10
byteHex = -10
byteOct = -10
byteBin = -10
```

- Since Java 7, numeric literals (source code representing a fixed value) can contain "_" between digits to improve readability.

```java
public class Primitives2 {
  public static void main(String[] args) {
    long intgrDec = 10_000_100;
    long intgrHex = 0x98_96_e4;
    long intgrOct = 0676_56_304;
    long intgrBin = 0b10011000_10010110_11100100;
    float floatDec = 10_000_100.00f; // f or F is required
    double doubleDec = 10_000_100.00;

    System.out.println("intgrDec = " + intgrDec);
    System.out.println("intgrHex = " + intgrHex);
    System.out.println("intgrOct = " + intgrOct);
    System.out.println("intgrBin = " + intgrBin);
    System.out.println("floatDec = " + floatDec);
    System.out.printf("floatDec = %.4f\n", floatDec);
    System.out.println("doubleDec = " + doubleDec);
    System.out.printf("doubleDec = %.1f\n", doubleDec);
  }
}
```

- OUTPUT

```
intgrDec = 10000100
intgrHex = 10000100
intgrOct = 14638276
intgrBin = 10000100
floatDec = 1.00001E7
floatDec = 10000100.0000
doubleDec = 1.00001E7
doubleDec = 10000100.0
```

- There are wrapper classes for the primitive types, which wrap each of the primitive types into an object. We will be discussing classes and objects soon.
- The wrapper classes allow us to have objects for each of the primitive classes, and have various methods to operate on the primitive type that is wrapped in the object:
  - `Byte, Short, Integer, Long, Float, Double, Boolean, Character`
- Example of using the Integer wrapper for `int` primitive type:

```java
public class Primitives3 {
  public static void main(String[] args) {
    int intValue = Integer.parseInt(args[0]);
    Integer intgrValue = Integer.valueOf(intValue);
    Integer intgrValue1 = Integer.valueOf(args[0]);

    System.out.println("intValue = " + intValue);
    System.out.println("intgrValue.toString() = " + intgrValue.toString());
    System.out.println("intgrValue1.toString() = " + intgrValue1.toString());
    System.out.println("intgrValue.intValue() = " + intgrValue.intValue());
    System.out.println("intgrValue1.intValue() = " + intgrValue1.intValue());
    System.out.println("Integer.toHexString(intValue) = " + Integer.toHexString(intValue));
    System.out.println("Integer.toOctalString(intValue) = " + Integer.toOctalString(intValue));
    System.out.println("Integer.toBinaryString(intValue) = " + Integer.toBinaryString(intValue));
  }
}
```

- OUTPUT

```
> java Primitives3 21
intValue = 21
intgrValue.toString() = 21
intgrValue1.toString() = 21
intgrValue.intValue() = 21
intgrValue1.intValue() = 21
Integer.toHexString(intValue) = 15
Integer.toOctalString(intValue) = 25
Integer.toBinaryString(intValue) = 10101
```

**Wrappers are immutable**
- Note that you can change the value of an `int` variable but you cannot change the value of an Integer object. You ask java to make a new object:

```java
  int intValue = Integer.parseInt(args[0]); // 21 in our test above
  Integer intgrValue = Integer.valueOf(intValue); // 21 wrapped in an object
  intValue = 2 * intValue; // now it is 42
  // no operation on intgrValue to change its values
  // we can only assign the variable to a new object:
  intgrValue = Integer.valueOf(intValue); // a new object wrapping 42
```
