class ArrayListAndVectorSampleCode
{
	public static void main(String[] args)
	{
		if( args.length != 1 )
		{
			System.out.println("format: ArrayListAndVectorSampleCode \"input filename\"");
			System.exit(0);
		}
		
		try
		{
			// instantiate a BufferedReader to read from the input file
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			String inn;
			
			// ArrayList<String> to temporarily store the lines from the input file
			java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();
			
			// Vector<String> to temporarily store the lines from the input file
			java.util.Vector<String> vector = new java.util.Vector<>();
			
			// read the input file and store the lines in inputLists
			while( (inn = input.readLine()) != null )
			{
				if( (inn.trim().length() > 0) && (!inn.trim().startsWith("#")) )
				{
					arrayList.add(inn.trim());
					vector.add(inn.trim());
				}
			}
			input.close();
			
			// output the size of the ArrayList and Vector
			System.out.println("arrayList.size() = " + arrayList.size());
			System.out.println("vector.size() = " + vector.size());
			
			System.out.println("content of arrayList with enhanced for loop");
			for( String s : arrayList )
			{
				System.out.println(s);
			}
			
			System.out.println("content of arrayList with non enhanced for loop");
			for( int i = 0; i < arrayList.size(); i++ )
			{
				System.out.println(arrayList.get(i));
			}
			
			System.out.println("content of arrayList with while loop and iterator");
			java.util.Iterator it = arrayList.iterator();
			while( it.hasNext() )
			{
				System.out.println(it.next());
			}
			
			String[] arrayListArray = arrayList.toArray(new String[0]);
			System.out.println("content of arrayList with with for loop and toArray result");
			for( int i = 0; i < arrayList.size(); i++ )
			{
				System.out.println(arrayListArray[i]);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}

	}
}
