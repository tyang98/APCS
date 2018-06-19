
/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public abstract class BankAccount
{
    private double balance;
    
    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount(double balance)
    {
        this.balance = balance;
    }
    
    /**
     * Constructs a bank account with a given balance.
     * @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    

    /**
     * Withdraws money from the bank account.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {	
    	balance = balance - amount;
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
    	balance = balance + amount;
    }
    
    /**
     * Gets the current balance of the bank account.
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Sets the balance of the bank account
     * @param balance the balance of the account
     */
    public void setBalance(double balance)
    {
    	this.balance = balance;
    }
    
   
    /**
     * Transfers money from the bank account to another account.
     * @param amount the amount to transfer
     * @param other the other account
     */
    public void transfer(double amount, BankAccount other)
    {
        withdraw(amount);
        other.deposit(amount);
    }
    
    /**
     * Performs different types of calculations to end the month for an account
     */
    public abstract void endOfMonth();
}


