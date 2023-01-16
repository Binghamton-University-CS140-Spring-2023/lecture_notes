class enhanced_for_loop
{
	public static void main(String[] args)
	{
		int[] int_arr = {11,22,33,44};

		for(int i : int_arr)
		{
			System.out.println("int: " + i);
		}

		String[] str_arr = {"cat", "dog", "fish", "peacock"};

		for(String str : str_arr)
		{
			System.out.println("String: " + str);
		}
	}
}
