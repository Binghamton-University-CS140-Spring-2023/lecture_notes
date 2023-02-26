class Fibonacci
{
	private static void fib_helper(long[] fib_nums, int i)
	{
		//This stops infinite recursion,
		//and also ensures we don't get an ArrayIndexOutOfBoundsException.
		if(i < fib_nums.length)
		{
			//base cases
			if(i == 0 || i == 1)
			{
				fib_nums[i] = i;
			}
			//general case
			else
			{
			fib_nums[i] = fib_nums[i-1] + fib_nums[i-2];
			}

			//leveraging recursion 
			//we specify to calculate the (i+1)th fibonacci number
			
			//Since we stop recursion when the whole array is populated,
			//This is valid.
			fib_helper(fib_nums, i+1);
		}
	}

	public static long fibonacci_amortized(int n)
	{
		//amortize - utilize more space
		long[] fib_nums = new long[n+1];

		//recursive helper.
		//Note the second parameter, specifies the 0th fibonacci 
		//number is to be calculated first.
		fib_helper(fib_nums, 0);

		return fib_nums[n];
	}

	public static long fibonacci(long n)
	{
		//base cases
		if( n == 0 || n == 1)
		{
			return n;
		}

		//recursive case
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static void main(String[] args)
	{
		int ith = 50;

		//System.out.println(fibonacci(ith));
		System.out.println(fibonacci_amortized(ith));
	}
}