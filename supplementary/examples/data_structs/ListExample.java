import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class ListExample
{
	public static void main(String[] args)
	{
		List<String> lst = new ArrayList<>();
		lst.add("cat");
		lst.add("dog");
		lst.add("elephant");
		
		System.out.println(lst.size());
		System.out.println(lst);
		
		lst.add("frog");
		System.out.println(lst.size());

		lst.remove(1);
		
		System.out.println(lst.size());
		System.out.println(lst);

		System.out.println(lst.indexOf("frog"));

		lst.add(1, "peach");
		System.out.println(lst);

		lst.set(2, "REPLACE");
		System.out.println(lst);

		Iterator<String> iter = lst.iterator();

		while(iter.hasNext())
		{
			iter.next();
			iter.remove();
		}

//		for(int i = lst.size() - 1; i >= 0; --i)
//		{
//			lst.remove(i);
//		}

		System.out.println(lst);
	}
}