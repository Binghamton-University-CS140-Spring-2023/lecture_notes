class BankAccount
{
	private final String ownerLastName;
	private final String ownerFirstName;
	private final String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int bankAccountCount = 0;
	
	BankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = makeAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
		bankAccountCount = bankAccountCount+1;
	}
	
	BankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		return false;
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		return false;
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		return false;
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		return false;
	}
	
	public void depositToSavings(double amount)
	{
	}
	
	public void depositToChecking(double amount)
	{
	}
	
	public String toString()
	{
		return "";
	}
	
	public String getOwnerLastName()
	{
		return "";
	}
	
	public String getOwnerFirstName()
	{
		return "";
	}
	
	public String getAccountNumber()
	{
		return "";
	}
	
	public double getCheckingBalance()
	{
		return 0.0;
	}
	
	public double getSavingsBalance()
	{
		return 0.0;
	}
	
	private String makeAccountNumber()
	{
		String aNumber = "" + bankAccountCount;
		
		while( aNumber.length() < 6 )
		{
			aNumber = "0" + aNumber;
		}
		return aNumber;
	}
	
	public static int getBankAccountCount()
	{
		return bankAccountCount;
	}
}
