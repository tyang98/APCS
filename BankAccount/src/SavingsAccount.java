
/**
 * An account that earns interest at a fixed rate
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minBalance;
    
    /**
     * Constructs a bank account with a given interest rate.
     * @param rate the interest rate
     * @param initialBalance the initial balance 
     */
    public SavingsAccount(double rate, double initialBalance)
    {
    	super(initialBalance);
        interestRate = rate;
        minBalance = 0;
        
    }
     
    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
    	super.withdraw(amount);
    	if (getBalance() < minBalance)
    	{
    		minBalance = getBalance();
    	}
    	
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
    	if (minBalance == 0 && getBalance() != 0)
    	{
    		minBalance = getBalance();
    	}
      	super.deposit(amount);
    }
    
    /**
     * Gets the current minimum balance of the bank account.
     * @return the minimum balance
     */
    public double getMinBalance()
    {
    	return minBalance;
    }

    /**
     * Sets the minimum balance for the bank account
     * @param minBalance the minimum balance for the account
     */
    public void setMinBalance(double minBalance)
    {
    	this.minBalance = minBalance;
    }

	
    /**
     * Adds the earned interest to the account balance.
     */
    public void endOfMonth()
    {
        double interest = getMinBalance() * interestRate / 100;
        deposit(interest);
        setMinBalance(getBalance());
    }
}

