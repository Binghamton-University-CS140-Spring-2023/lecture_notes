class BicycleDriver
{
	public static void main(String[] args)
	{
		Bicycle b1 = new Bicycle();
		Bicycle b2 = new Bicycle();
		
		System.out.println("Before speed up: ");
		b1.printStates();
		b2.printStates();
		
		b1.speedUp(5);

		System.out.println("After speed up: ");		
		b1.printStates();
		b2.printStates();
	}
}
