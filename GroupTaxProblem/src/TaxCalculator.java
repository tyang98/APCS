import java.util.Scanner;

/**
 * Calculates the tax for items based on Crazy Sales Tax
 * @author Jeff Lantz and Tony Yang
 * @version 1.19.18
 */
public class TaxCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		taxCalc(input);
		input.close();
		
	}
	
	/**
	 * Calculates and prints the subtotal, total taxes, and grand total of various products
	 * @param input The scanner to receive the cost of the product
	 */
	public static void taxCalc(Scanner input)
	{
		int subtotal = 0;
		double taxes = 0.0;
		
		int cost = input.nextInt();
		while (cost > 0)
		{
			if (cost % 2 == 0)
			{
				subtotal += cost;
			}
			else
			{
				subtotal += cost;
				taxes += (cost % 10) / 100.0 * cost;
			}
			cost = input.nextInt();
		}
		String grandTotal = "" + (int)((subtotal + taxes) * 1000 + 0.5) / 1000.0;
		String tax = (int)(taxes * 1000 + 0.5) / 1000.0 + "";
		System.out.println("Subtotal = " + subtotal + "\nTotal Taxes = " + tax
						+ "\nGrand Total = " + grandTotal);
	}
}
