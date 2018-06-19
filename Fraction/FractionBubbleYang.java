
import java.io.*;
import java.util.*;

/**
 * Performs Bubble Sort on various fractions
 * @author Tony Yang
 */
public class FractionBubbleYang 
{
    private static int SIZE = 50;
    private static List<Fraction> fractions = new ArrayList<Fraction>();
      
    private static void initValues()
    // Initializes the fractions ArrayList with random fractions
    {
        Random rand = new Random(560);
        System.out.println(rand);
        for (int index = 0; index < SIZE; index++)
            fractions.add(new Fraction (Math.abs(rand.nextInt()) % 100, Math.abs(rand.nextInt()) % 100));
    }
    
    public static boolean isSorted()
    // Determine whether the array fractions are sorted
    {
        boolean sorted = true;
        for (int i = 0; i < fractions.size() - 1; i++)
            if (fractions.get(i).compareTo(fractions.get(i + 1)) > 0)
                sorted = false;
        return sorted;
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array fractions
    // Precondition:  index1 and index2 are less than size
    {
        Fraction temp = fractions.get(index1);
        fractions.set(index1, fractions.get(index2));
        fractions.set(index2, temp);
    }
    
    public static void printValues()
    // Prints all the fractions 
    {
        Fraction value;
        System.out.println("the fractions arraylist is:");
        for (int index = 0; index < SIZE; index++) {
            value = fractions.get(index);
            if (((index + 1) % 10) == 0)
                System.out.println(value);
            else
                System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void bubbleSort () {
        for (int i = 0; i < fractions.size(); i++)
            bubbleUp(0, i);
    }
    
    public static void bubbleUp(int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex + 1; i--) {
            if (fractions.get(i).compareTo(fractions.get(i - 1)) < 0)
            {
                swap(i, i - 1);
            }
        }
    }
    
    public static void main (String[] args) {
    	initValues();
        bubbleSort();
        printValues();
        System.out.println("Fractions are sorted: " + isSorted());
        System.out.println();

        swap(0, 1);
        bubbleSort();
        printValues();
        System.out.println("Fractions are sorted: " + isSorted());
        System.out.println();
    }
}

/**
 * Simulates a fraction
 * @author Tony Yang
 * @version 12.27.17 
 */
class Fraction implements Comparable<Fraction>
{
	private int numerator;
	private int denominator;

	/**
	 * Create a fraction given a numerator and denominator
	 * @param numerator the numerator of the fraction
	 * @param denominator the denominator of the fraction
	 */
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
        this.denominator = denominator;
	}

	 
    /**
     * Returns the fraction's denominator
     * @return the fraction's denominator
     */
    public int getDenominator ()
    {
        return denominator;
    }
    
    /**
     * Returns the fraction's numerator
     * @return the fraction's numerator
     */
    public int getNumerator ()
    {
        return numerator;
    }
    
	/**
	 * Return the GCD of numerator and denominator
	 * @param numerator the first number to get the GCD of
	 * @param denominator the second number to get the GCD of
	 * @return the GCD of numerator and denominator
	 */
	private static int getGCD(int numerator, int denominator)
	{
		if (denominator == 0)
		{
			return numerator;
		}

		return getGCD(denominator, numerator % denominator);
	}


	/**
	 * Return the value of the fraction as a double
	 * @return the value of the fraction as a double
	 */
	public double getDoubleValue()
	{
		return numerator / denominator;
	}

	/**
	 * Simplify the fraction to lowest terms. 
	 */
	public void reduce()
	{
		int gcd = getGCD(numerator, denominator);

		numerator /= gcd;
		denominator /= gcd;
	}

	/**
	 * Compare the fraction object in the implicit parameter with the supplied fraction
	 * @param obj the fraction to compare the implicit parameter to
	 * @return a negative number if the supplied fraction is greater than the implicit, a positive number if the implicit fraction is greater than the supplied, and zero if the two fractions are equal
	 */
	@Override
	public int compareTo(Fraction frac) 
	{
		//Numerators where both have common denominators
		int implNumerator = this.numerator * frac.denominator;
		int suppNumerator = frac.numerator * this.denominator;

		return implNumerator - suppNumerator;
	}

	/**
	 * Return a string representation of the fraction
	 * @return a string representation of the fraction
	 */
	@Override
	public String toString()
	{
		return numerator + "/" + denominator;
	}
}

