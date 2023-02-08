
class StaticExample
{
	int idCount = 0;
	int myId;
	int x;

	public StaticExample(int x)
	{
		this.myId = ++idCount;
		this.x = x;
	}

	public String toString()
	{
		return this.myId + " " + this.x;
	}

	public int getId()
	{
		return this.myId;
	}

	public static void main(String[] args)
	{
		StaticExample s1 = new StaticExample(3);
		StaticExample s2 = new StaticExample(4);
		StaticExample s3 = new StaticExample(5);


		s1.getId();
		s2.getId();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}

struct Appendable
{
	int foo(Appendable self, int x);
}