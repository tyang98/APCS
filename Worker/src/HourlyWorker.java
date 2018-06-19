
/**
 * Simulates an hourly worker
 * @author Tony Yang
 * @version 10.20.17
 */
public class HourlyWorker extends Worker
{
	final static double OVERTIME = 1.50;
	final static double OVERTIME_HOUR = 40.0;
	
	/**
     * Creates a worker given name and payment
     * @param The name of the worker
     * @param The amount of money the worker is paid per hour
     */
    public HourlyWorker(String name, double payment)
    {
        super(name, payment);
    }
    
    /**
     * Returns the computed payment for an hourly worker as a String
     * @param hours The number of hours a worker works
     * @return The computed payment based on hours worked including overtime 
     */
        public String computePay(int hours)
        {
        	double overtimepay;
    	
        	if (hours > 40)
        	{
        		overtimepay = (OVERTIME_HOUR * getWorkerPayment()) + ((hours - OVERTIME_HOUR) * OVERTIME * getWorkerPayment());
        		return String.format("$%.2f", overtimepay);
        	}
        	else
        	{
			return super.computePay(hours);
        	}
        }
}
