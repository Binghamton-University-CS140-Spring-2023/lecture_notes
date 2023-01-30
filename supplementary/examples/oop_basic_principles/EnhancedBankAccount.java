import java.util.ArrayList;
import java.util.Date;

class EnhancedBankAccount extends BankAccount
{
	private ArrayList<Transaction> successfulTransactions;
	private ArrayList<Transaction> failedTransactions;
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		super(ownerLastName, ownerFirstName, checkingBalance, savingsBalance);
		
		successfulTransactions = new ArrayList<>();
		failedTransactions = new ArrayList<>();
	}
	
	EnhancedBankAccount(String ownerLastName, String ownerFirstName)
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
	
	public ArrayList<Transaction> getAllSuccessfulTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getAllFailedTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsDepositTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	private ArrayList<Transaction> getTransactions(String transactionType)
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingDepositTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsWithdrawalTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingWithdrawalTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSavingsToCheckingTransferTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getCheckingToSavingsTransferTransactions()
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getFailedTransactions(Date startDate, Date endDate)
	{
		return new ArrayList<Transaction>();
	}
	
	public ArrayList<Transaction> getSuccessfulTransactions(Date startDate, Date endDate)
	{
		return new ArrayList<Transaction>();
	}
}
