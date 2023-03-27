/*
- static and instance fields
- static and instance methods

- ArrayDeque (queue and stack functionality)
- the equality operator "==" and comparing objects via the equals() method
- ByteBuffer
- arrays
- ArrayList
- connected and strongly connected graphs

- TreeSet
- HashSet

- StringTokenizer & parsing text
- JUnit test

- automatic conversion of parameters
- recursive functions
*/

//Interfaces / Inheritance / final keyword

interface ShapeInfo
{
	public double perimeter();
	public double area();
	public int numSides();

	public default int foo()
	{
		return 10;
	}
}

class Shape
{
	protected final double x;
	protected final double y;

	public Shape(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

}

class Circle extends Shape implements ShapeInfo
{
	public Circle(double x, double y)
	{
		super(x,y);
	}

	public double perimeter(){ return 0; }
	public double area() { return 0; }
	public int numSides() { return -1; }

	@Override
	public int foo()
	{
		return 3;
	}
}

class RightTriangle extends Shape implements ShapeInfo
{
	public RightTriangle(double leg1, double leg2)
	{
		super(leg1, leg2);
	}

	public double perimeter()
	{
		double hyp = Math.sqrt(getX() * getX() + getY() * getY());
		return hyp + getX() + getY();
	}

	public double area()
	{
		return 0.5 * getX() * getY();
	}

	public int numSides()
	{
		return 3;
	}

	public String toString()
	{
		return "==== Right Triangle ====" + 
			   "\nLeg 1:     " + getX() +
			   "\nLeg 2:     " + getY() +
			   "\nPerimeter: " + perimeter() +
			   "\nArea:      " + area() +
			   "\nNum sides: " + numSides();

	}
}

class Rectangle extends Shape implements ShapeInfo
{
	public Rectangle(double length, double width)
	{
		super(length, width);
	}

	public double perimeter()
	{
		return 2.0*(getX() + getY());
	}

	public double area()
	{
		return getX() * getY();
	}

	public int numSides()
	{
		return 4;
	}

	//give 10 more minutes on exam

	public String toString()
	{
		return "==== Rectangle ====" +
			   "\nLength:    " + getX() +
			   "\nWidth:     " + getY() + 
			   "\nPerimeter: " + perimeter() +
			   "\nArea:      " + area() +
			   "\nNum sides: " + numSides();

	}
}

/*

- the equality operator "==" and comparing objects via the equals() method
- ByteBuffer
- connected and strongly connected graphs


- JUnit test

- automatic conversion of parameters
- recursive functions
*/

//Recursion / static  

class Recursion
{
	public static int sum(java.util.ArrayList<Integer> list)
	{
		if(list.size() == 0)
		{
			return 0;
		}

		Integer i = list.get(0);
		list.remove(0);

		return i + sum(list);
	}
}


//Review TreeSet / HashSet / ArrayList / arrays / ArrayDeque (queue / stack)
//ByteBuffer

//equals() vs ==
//junit tests

class Review//automatic conversion of parameters / overloaded functions

{
	public static void main(String[] args)
	{
		Shape a = new Rectangle(5,6);
		Shape b = new RightTriangle(3,4);

		System.out.println(a);
		System.out.println(b);

		java.util.ArrayList<Integer> list1 = new java.util.ArrayList<>();
		java.util.ArrayList<Integer> list2 = new java.util.ArrayList<>();

		list1.add(new Integer(1));
		list2.add(new Integer(1));

		for(int i = 0; i < list1.size(); ++i)
		{
			Integer j = list1.get(i);
			int k = list2.get(i).intValue();

			System.out.println(j == k);
		}

		list2.add(3);
		list2.add(4);
		list2.add(5);

		System.out.println(list2);

		System.out.println(Recursion.sum(list2));
				System.out.println(list2);

	}
}