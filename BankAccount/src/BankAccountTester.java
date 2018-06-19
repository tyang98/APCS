/**
 * Tests the Bank Account class
 * @author Tony Yang
 * @version 10.28.17
 */
public class BankAccountTester {
	public static void main(String[] args)
	{
		SavingsAccount savings1 = new SavingsAccount(10, 200);
		CheckingAccount checking1 = new CheckingAccount(200);
		TimeDepositAccount time1 = new TimeDepositAccount(10, 200, 5);
		
		savings1.deposit(20);
		System.out.println("MinSavings Account Balance:" + savings1.getMinBalance());
		savings1.withdraw(120);
		System.out.println("MinSavings Account Balance:" + savings1.getMinBalance());
		savings1.deposit(170);
		savings1.deposit(10);
		savings1.withdraw(75);
		savings1.endOfMonth();
		System.out.println("Savings Account Balance:" + savings1.getBalance());
		
		checking1.deposit(20);
		checking1.withdraw(120);
		checking1.deposit(170);
		checking1.deposit(10);
		checking1.withdraw(75);
		checking1.endOfMonth();
		System.out.println("Checking Account Balance:" + checking1.getBalance());
		
		time1.deposit(20);
		time1.withdraw(120);
		time1.deposit(170);
		time1.deposit(10);
		time1.withdraw(75);
		time1.endOfMonth();
		System.out.println("Time Deposit Account Balance:" + time1.getBalance());
		
	}
}
