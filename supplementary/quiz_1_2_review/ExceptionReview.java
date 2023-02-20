import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.Arrays;

class ExceptionReview
{
	static int[] array = new int[4];

	public static void main(String[] args)
	{
		String input = "11x,12y,13,14,cat,15,16,17,18,19";

		StringTokenizer st = new StringTokenizer(input, ",");

		int idx = -1;
		String token = "";
		while(st.hasMoreTokens())
		{
			try
			{
				token = st.nextToken();
				int i = Integer.parseInt(token);
				array[idx++] = i;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Error - skipped token that was not a number: " + token);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error - Array is full, skipping token: " + token);
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Error - some unknown error with the StringTokenizer");
			}
			catch(Exception e)
			{
				System.out.println("Error - unhandled error occurred");
			}
		}

		System.out.println("Result:" + Arrays.toString(array));
	}
}