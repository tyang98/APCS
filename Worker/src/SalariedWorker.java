
/**
 * Simulates a salaried worker
 * @author Tony Yang
 * @version 10.20.17
 */
public class SalariedWorker extends Worker
{
	final static int SALARY_PAY = 40;
    
	/**
     * Creates a worker given name and payment
     * @param The name of the worker
     * @param The amount of money the worker is paid per hour
     */
    public SalariedWorker(String name, double payment)
    {
        super(name, payment);
    }
    
    /**
     * Returns the computed payment for a salaried worker as a String
     * @param hours The number of hours a worker works
     * @return The computed payment for 40 hours of work
     */
    public String computePay(int hours)
    {
        return super.computePay(SALARY_PAY);   
    }

}
