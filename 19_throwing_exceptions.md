-------------------
Throwing Exceptions
-------------------

## [Throwing Exceptions - From the Java Tutorials](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

"Before you can catch an exception, some code somewhere must throw one. Any code can throw an exception: your code, code from a package written by someone else such as the packages that come with the Java platform, or the Java runtime environment. Regardless of what throws the exception, it's always thrown with the ***`throw` statement***."

## The Throw Statement

All methods use the `throw` statement to throw an exception. The `throw` statement requires a single argument: a throwable object. Throwable objects are instances of any subclass of the `Throwable`class. Here's an example of a throw statement:

```java
throw someThrowableObject;
```

## Exceptions extend the Throwable class

Of course, you can probably infer that the `Exception` class must extend the `Throwable` class, since we can `throw` an `Exception` at runtime.

## Tying it to our Graph class

Four our `Graph` class, we have three cases that we need to `throw` a `GraphException`.

1. Attempt to add a duplicate vertex

```java
throw new GraphException("attempting to add duplicate vertex \"" + v + "\"");
```
2. Attempt to add a duplicate edge

```java
throw new GraphException("attempting to add duplicate edge \"(" + from + "," + to + ")\"");
```

3. Attempt to add an invalid edge (at least one of the vertices do not exist)

```java
throw new GraphException("attempting to add edge with undefined vertex\"(" + from + "," + to + ")\"");
```
