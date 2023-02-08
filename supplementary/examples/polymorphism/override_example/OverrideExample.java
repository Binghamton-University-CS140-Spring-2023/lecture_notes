class A
{
	public int foo(int x, int y)
	{
		return x + y;
	}
}

class B extends A
{
	@Override
	public int foo(int x, int y)
	{
		int baseVal = super.foo(x,y);
		return 3*x + baseVal;
	}
}

class C extends B
{
	@Override
	public int foo(int x, int y)
	{
		return super.foo(x,y) - y;
	}
}

class OverrideExample
{
	public static void main(String[] args)
	{
		C cObj = new C();
		System.out.println(cObj.foo(3,5));
	}
}