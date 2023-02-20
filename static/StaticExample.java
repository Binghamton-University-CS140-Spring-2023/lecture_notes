import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class StaticExample
{
	public static int x;
	public int y;

	public static void foo1()
	{
		x = 3;
		//y = 5;
	}

	public void foo2()
	{
		x = 3;
		y = 5;
	}

	public static void main()
	{
		Set<Double> hash_set = new HashSet<>();

		Iterator<Double> iter = hash_set.iterator();

		while(iter.hasNext())
		{
			Double d = iter.next();
			System.out.println(d);
		}
	}
}