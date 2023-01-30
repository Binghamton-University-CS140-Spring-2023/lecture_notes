class ArrayList_Example
{
	public enum Execute
	{
		FORWARD_REMOVE,
		ITERATOR_REMOVE,
		BACKWARD_REMOVE
	}

	public static void main(String[] args)
	{

		//Change this enumeration to specify what gets executed.
		Execute exe  = Execute.FORWARD_REMOVE;
		String context = "";

		java.util.ArrayList<Integer> lst = new java.util.ArrayList<>();

		lst.add(1);
		lst.add(23);
		lst.add(3);
		lst.add(3);
		lst.add(4);
		lst.add(5);
		lst.add(6);

		System.out.println("============= List Removal caveats ==================");
		System.out.println("LIST BEFORE: " + lst);

		switch(exe)
		{
		case FORWARD_REMOVE:
			for(int i = 0; i < lst.size(); ++i)
			{
				lst.remove(i);
			}
			context = "Removed forward: ";
		break;
		case ITERATOR_REMOVE:
		java.util.Iterator<Integer> itr = lst.iterator();
			while(itr.hasNext())
			{
				itr.next();
				itr.remove();
			}
			
			context = "Removed via iterator: ";
		break;
		case BACKWARD_REMOVE:
			for(int i = lst.size() -1; i >= 0; --i)
			{
				lst.remove(i);
			}	
			context = "Removed backward: ";
		break;
		}
		
		System.out.println(context + lst);

		System.out.println("======== ARRAYS toString() =================");		
		int[] arr = {1,2,3,4,5,5,6};
		System.out.println("NATIVE ARRAY PRINT: " + arr);
		System.out.println("Arrays toString():  " + java.util.Arrays.toString(arr));
	}
}
