class Bird
{	
	protected String m_name;
	
	public Bird(String name)
	{
		m_name = name;
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Bird)";
	}
	
	public void sing()
	{
		System.out.println("Who knows what the mystery bird sings?");
	}
}

class BlueJay extends Bird
{

	public BlueJay(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (BlueJay)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("BlueJays sing the blues.");
	}
}

class Canary extends Bird
{

	public Canary(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Canary)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("Canaries tweet happily.");
	}
}

class Cardinal extends Bird
{

	public Cardinal(String name)
	{
		super(name);
	}
	
	@Override
	public String toString()
	{
		return m_name + " (Cardinal)"; 
	}
	
	@Override
	public void sing()
	{
		System.out.println("Cardinals enjoy the classical.");
	}
}

class BirdHouse
{	
	public static void main(String[] args)
	{
		java.util.List<Bird> birdList = new java.util.ArrayList<>();
		birdList.add(new Bird("Lester"));
		birdList.add(new BlueJay("Gerald"));
		birdList.add(new Canary("Henry"));
		birdList.add(new Cardinal("Alice"));
	
		System.out.println("=====================================");
		System.out.println("         Dynamic dispatching         ");
		System.out.println("=====================================");
		for(Bird bird : birdList)
		{
			System.out.println(bird);
			bird.sing();
			System.out.println("*******************************");
		}
		
		System.out.println("\n\n=====================================");
		System.out.println("           Is a Relationship             ");
		System.out.println("=========================================");
		for(Bird bird : birdList)
		{
			System.out.println(bird);
			System.out.println("class name:    " + bird.getClass().getName());
			System.out.println("Is an Object:  " + (bird instanceof Object));		
			System.out.println("Is a Bird:     " + (bird instanceof Bird));
			System.out.println("Is a Bluejay:  " + (bird instanceof BlueJay));
			System.out.println("Is a Cardinal: " + (bird instanceof Cardinal));
			System.out.println("Is a Canary:   " + (bird instanceof Canary));
			System.out.println("*******************************");
		}
	}
}
