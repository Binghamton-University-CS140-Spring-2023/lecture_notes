class StreamFun
{

	public static void main(String[] args)
	{
		java.util.ArrayList<Long> list = new java.util.ArrayList<>();

		for(long i = 1; i <= 20; ++i)
		{
			list.add(i);
		}

		//Lets try to calculate the sum of all the elements in this list
		long sum = list.stream()
			          .reduce(1L, (a,b) -> a * b);

	 	System.out.println(sum);
	}
}