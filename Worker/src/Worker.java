
/**
 * Simulates a worker and their payment
 * @author Tony Yang
 * @version 10.20.17
 */
public class Worker
{
    private String myWorkerName;
    private double myWorkerPayment;
    
    /**
     * Creates a worker given name and payment
     * @param name The name of the worker
     * @param payment The amount of money the worker is paid per hour
     */
    public Worker(String name, double payment)
    {
        myWorkerName = name;
        myWorkerPayment = payment;
    }
    
    /**
     * Returns the worker's name
     * @return The worker's name
     */
    public String getWorkerName()
    {
        return myWorkerName;
    }
    
    /**
     * Returns the worker's payment
     * @returns the worker's payment
     */
    public double getWorkerPayment()
    {
        return myWorkerPayment;
    }
    
    /**
     * Returns the computed payment for a worker as a String
     * @param hours The number of hours a worker works
     * @return The computed payment for a worker
     */
    public String computePay(int hours)
    {
        double workPayment;
        workPayment = myWorkerPayment * hours;
        return String.format("$%.2f", workPayment);
    }
}
