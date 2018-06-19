/**
 * Simulates a fraction
 * @author Tony Yang
 * @version 12.27.17 
 */
public class Fraction implements Comparable<Fraction>
{
	private int myNumerator;
	private int myDenominator;
	
	/**
	 * Creates a fraction with a numerator and denominator
	 * @param numerator The numerator of a fraction
	 * @param denominator The denominator of a fraction
	 * Precondition: denominator != 0
	 */
	public Fraction(int numerator, int denominator)
	{
		myNumerator = numerator;
		myDenominator = denominator;
	}
	
	/**
	 * Compares the implicit fraction with the explicit fraction
	 * @param frac The fraction that is compared to the implicit fraction
	 * @return The value of zero, a positive number, or negative number
	 */
	public int compareTo(Fraction frac)
	{
		int implicitFraction = myNumerator * frac.myDenominator;
		int explicitFraction = frac.myNumerator * myDenominator;
		return implicitFraction - explicitFraction;
	}
	
	/**
	 * Returns the greatest common divisor of the numerator and denominator
	 * @param The numerator of the fraction
	 * @param The denominator of the fraction
	 * @return The greatest common divisor of the numerator and denominator
	 */
	public int getGCD(int numerator, int denominator)
	{
		if (denominator == 0)
		{
			return numerator;
		}
		else
		{
			return getGCD(denominator, numerator % denominator);
		}
	}
	
	/**
	 * Reduces a fraction to simplest form;
	 */
	public void reduce()
	{
		int divider = getGCD(myNumerator, myDenominator);
		myNumerator /= divider;
		myDenominator /= divider;
	}
	
	/**
	 * Returns the fraction as a string
	 * @return The fraction as a string
	 */
	public String toString()
	{
		return myNumerator + "/" + myDenominator;
	}
}
