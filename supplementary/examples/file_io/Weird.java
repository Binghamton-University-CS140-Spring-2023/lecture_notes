class Weird
{

public static void main(String[] args)
{
	Integer i = Integer.valueOf(3);
	int j = 3;
	Integer k = Integer.valueOf(3);

	Integer w = new Integer(3);

	System.out.println(i == j);
	System.out.println(j == k);
	System.out.println(i == k);

	System.out.println(i.equals(w));
	System.out.println(j == w);
}
}