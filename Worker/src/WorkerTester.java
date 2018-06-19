
/**
 * Tests the worker class
 * @author Tony Yang
 * @version 10.20.17
 */
public class WorkerTester 
{
	public static void main(String[] args)
	{
		Worker worker1 = new Worker("Bob", 12.3);
		System.out.println("Worker Paycheck: " + worker1.computePay(43));
		Worker worker2 = new HourlyWorker("Tony", 12.3);
	    System.out.println("Hourly Worker Paycheck: " + worker2.computePay(43));
	    Worker worker3 = new SalariedWorker("Jim", 12.3);
	    System.out.println("Salaried Worker Paycheck: " + worker3.computePay(43));
	}
}
