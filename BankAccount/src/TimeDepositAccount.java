
public class TimeDepositAccount extends SavingsAccount 
{
	private double timeDeposit;
	public final static double PENALTY = 45.0;
	
	 /**
     * Constructs a bank account with a given interest rate.
     * @param rate the interest rate
     * @param initialBalance the initial balance 
     * @param time the number of months money is left in account
     */
	public TimeDepositAccount(double rate, double initialBalance, double time)
	{
		super(rate, initialBalance);
		this.timeDeposit = time;
	}

	/**
     * Withdraws money from the savings account with a penalty for early withdrawal
     * @param amount the amount to withdraw
     */
	public void withdraw(double amount)
    {
		if (timeDeposit > 0)
		{
			this.setBalance(getBalance() - PENALTY);
		}
    	super.withdraw(amount);
    	
    }
	
	/**
     * Adds the earned interest to the account balance
     */
	public void endOfMonth()
    {
		super.endOfMonth();
        this.timeDeposit--;
    }
}
