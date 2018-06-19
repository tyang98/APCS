/** 
 * Tests the Fraction Class
 * @author Tony Yang
 * @version 11.27.17
 */
public class FractionTester
{
	public static void main(String[] args)
	{
		System.out.println("First Fraction Test:");
		Fraction frac1 = new Fraction(6, 12);
		System.out.println("Fraction: " + frac1);
		frac1.reduce();
		System.out.println("Reduce fraction  to: " + frac1);
		
		System.out.println("Second Fraction Test:");
		Fraction frac2 = new Fraction(-6, 8);
		System.out.println("Fraction: " + frac2);
		frac2.reduce();
		System.out.println("Reduce fraction to: " + frac2);
		
		System.out.println("Third Fraction Test:");
		Fraction frac3 = new Fraction(7,22);
		System.out.println("Fraction: " + frac3);
		frac3.reduce();
		System.out.println("Fraction reduced is still: " + frac3);
		
		System.out.println("Last Fraction Test:");
		Fraction frac4 = new Fraction(1, 2);
		Fraction frac5 = new Fraction(3, 5);
		System.out.println("First Fraction: " + frac4);
		System.out.println("Second Fraction: " + frac5);
		System.out.println("Compare first fraction to second fraction : " + frac4.compareTo(frac5));
		
	}
}
