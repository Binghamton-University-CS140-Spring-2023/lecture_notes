//Rotates an array by the specified shift.
//Shows one example where a do while loop is natural.
class Array_Rotator
{
	public static int[] arr = {1,2,3,4,5,6,7};
	
	public static int parseInput(String input)
	{
		int shift = 0;
		try
		{
			shift = Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			System.out.println("invalid shift supplied. defaulting to 0.");
		}

		shift = shift % arr.length;

		while(shift < 0)
		{
			shift += arr.length;
		}
		
		return shift;
	}


	public static void shiftPrint(int shift)
	{
		int i = shift;
		do
		{
			System.out.println(arr[i]);
			i = (i+1) % arr.length;
		}
		while(i != shift);
	} 

	public static void main(String[] args)
	{
		int shift = 0;
		
		if(args.length > 0)
		{
			shift = parseInput(args[0]);
			shiftPrint(shift);
		}
		else
		{
			System.out.println("Usage ./Array_Rotator [shift]");
		}
	}
}
