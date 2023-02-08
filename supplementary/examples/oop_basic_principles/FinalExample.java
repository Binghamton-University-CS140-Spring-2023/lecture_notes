class Transaction
{
	final private String type;
	final private java.util.Date date;
	final private double amount;
	
	Transaction(String type, java.util.Date date, double amount)
	{
		this.type = type;
		this.date = date;
		this.amount = amount;
	}
	
	public java.util.Date getDate()
	{
		return date;
	}
	
	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double newAmt)
	{
		this.amount = newAmt;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String toString()
	{
		return type + " " + date.toString() + " " + amount;
	}
}