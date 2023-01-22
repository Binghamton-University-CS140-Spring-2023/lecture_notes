-------------------------------------
Arrays of primitive types
-------------------------------------

**Array Definition**
- An array of a primitive type is sequence of the primitive type that is referenced as a single variable

**Indexing into an Array**
- Example
  - If `intValues` is an array of size 10 of type `int`, then the name `intValues` can be used to reference all 10 `int` values associated with the array `intValues`, with `intValues[0]` being the first element of the array, `intValues[1]` the second, ..., and `intValues[9]` being the 10th value
  
**Array declaration and intialization**  
- To declare `intValues` as an array:

```java
 int[] intValues;
 ```
- To specify `intValues` size (allocate memory versus define as an array)

```java
int[] intValues = new int[10];
```

- Alternatives are

```java
int intValues1[] = new int[10]; // originally for C compatability
int[] intValues2;
intValues2 = new int[10];
int[] intValues4 = {0,1,2,3,4,5,6,7,8,9};
int[] intValues3 = new int[]{0,1,2,3,4,5,6,7,8,9};
// the last form can be used to completely reassign an array variable:
intValues4 = new int[]{5,3,2,1};
```

**Default Values**

- Java arrays of primitive values are in initialized to their default value
  - 0 for integer types, 0.0 for float types, and false for boolean types

**Array Allocation** 

- Java arrays of primitives are allocated in heap memory


**Multi Dimensional Arrays**

- Arrays can have multiple dimensions

```java
int[][][] intValues = new int[10][20][30];
```

  - `intValues.length = 10`
  - `intValues[0].length = 20`
  - `intValues[0][0].length = 30`
  
- Note that accessing an element in a 3 dimensional array has the form `intValues[7][13][10]`, where `0<=7<=10`, `0<=13<=20`, `0<=10<=30`. 

**Empty Arrays**

- Arrays can have `length` 0, meaning they are empty:

```java
int[] intValues = new int[0]; // is valid
```

**Jagged Arrays**

- The following are also valid:

```java
int[][] v = new int[3][];
v[0] = new int[10];
v[1] = new int[20];
v[2] = new int[30];
```
  - `v.length = 3`
  - `v[0].length = 10`
  - `v[1].length = 20`
  - `v[2].length = 30`
  - We call `v` a jagged array.

**Other primitive type arrays**

- There can also be arrays of primitive values utilizing `boolean`, `byte`, `short`, `char`, `long`, `float`,`double`
