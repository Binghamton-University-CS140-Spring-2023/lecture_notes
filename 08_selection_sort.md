---------------------------------
Selection Sort
---------------------------------

This algorithm is called ***selection*** sort because it repeatedly ***selects*** the next-smallest element and swaps it into place.

**Pseudo code for selection sort**

- Let `values` be the `int` array to be sorted.

``` java
for( int i = 0; i < values.length; i++ )
{
	for( int j = i+1; j < values.length; j++ )
	{
		if( values[j] < values[i] )
		{
		    //Swap values[i] & values[j]
		}
	}
}
```

**Some Things to Note**

- Suppose the array to sort has length n
- Best-case number of swaps: 0 (already sorted)
- Worst-case number of swaps: n-1 **(or more potentially)**
- Number of comparisons: n-1 + n-2 + n-3 + ... + 3 + 2 + 1 = (n-1)(n) / 2.

**Alternate pseudo code for selection sort**

``` java
for( int i = 0; i < values.length; i++ )
{
    min = i
    for( int j = i+1; j < values.length; j++ )
    {
        if( values[j] < values[min] )
        {
        min = j
        }
    }
    
    if( min != i )
    {
        //Swap values[i] & values[min]
    }
}
```

[Alternate Selection Sort in Action](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

- Yellow represents a value being finalized (the swap that occurs between the ith index and min index)
- Blue represents searching for the next minimum (the inner j loop) 
- Red represents the current minimum found (updated during the inner j loop)

**Some Things to Note**

- Suppose the array to sort has length n
- Best-case number of swaps: 0 (already sorted)
- Worst-case number of swaps: n-1 **(at most)**
- Number of comparisons: n-1 + n-2 + n-3 + ... + 3 + 2 + 1 = (n-1)(n) / 2.

**Time Differences**

- For large files in which there are a large number of swapping of
values[i] and values[j], the alternate version will be somewhat
faster, due to only swapping values[i] and values[min] at most once per outer loop
- On my laptop, one of the test files for programming assignment 8 from last semester, consisting of 100,000 pseudo random integers, took approximately 12 seconds to sort using the original version of selection sort versus 4 seconds to sort using the alternate version.
