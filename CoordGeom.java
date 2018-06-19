					

/**
 * This class uses input values to perform
 * various coordinate geometry calculations 
 * @author Tony Yang
 * @version 9.21.17
 */

import java.util.Scanner;
public class CoordGeom 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the x coordinate for point A: ");
		double pointAX = input.nextDouble(); 
		System.out.println("Enter the y coordinate for point A: ");
		double pointAY = input.nextDouble(); 
		System.out.println("Enter the x coordinate for point B: ");
		double pointBX = input.nextDouble(); 
		System.out.println("Enter the y coordinate for point B: ");
		double pointBY = input.nextDouble(); 
		
		System.out.println("The slope of AB is: " 
					+ getSlope(pointAX, pointAY, pointBX, pointBY));
		System.out.println("The length of AB is: " 
				      + getLength(pointAX, pointAY, pointBX, pointBY));
		System.out.println("The midpoint of AB is: "
					+ getMidpoint(pointAX, pointAY, pointBX, pointBY)); 
		System.out.println("The minimum x coordinate of AB is: " 
					+ getMinX(pointAX, pointAY, pointBX, pointBY));
	}
	
	/**
	 * Returns the slope between points A and B
	 * @param pointAX The x value of point A
	 * @param pointAY The y value of point A
	 * @param pointBX The x value of point B
	 * @param pointBY The y value of point B
	 * @return The slope between point A and point B
	 */
	public static String getSlope(double pointAX, double pointAY, double  pointBX, double pointBY)
	{
		if (pointAX == pointBX)
		{
			return "Slope is Undefined";
		}
		return "" + (pointBY - pointAY) / (pointBX - pointAX);
	}
	
	/**
	 * Returns the length between points A and B using the distance formula
	 * @param pointAX The x value of point A
	 * @param pointAY The y value of point A
	 * @param pointBX The x value of point B
	 * @param pointBY The y value of point B
	 * @return The length between points A and B
	 */
	public static double getLength(double pointAX, double pointAY, double pointBX, double pointBY)
	{
		return Math.sqrt(Math.pow((pointBX - pointAX) , 2)
				     + Math.pow((pointBY - pointAY) , 2 ));
	}
	
	/**
	 * Returns the midpoint between points A and B
	 * @param pointAX The x value of point A
	 * @param pointAY The y value of point A
	 * @param pointBX The x value of point B
	 * @param pointBY The y value of point B
	 * @return The midpoint between points A and B
	 */
	public static String getMidpoint(double pointAX, double pointAY,double pointBX, double pointBY)
	{
		double midpointX = (pointAX + pointBX) / 2;
		double midpointY = (pointAY + pointBY) / 2;
		
		return "(" + midpointX + ", " + midpointY + ")";
	}
	
	/**
	 * Returns the minimum x coordinate between points A and B
	 * @param pointAX The x value of point A
	 * @param pointAY The y value of point A
	 * @param pointBX The x value of point B
	 * @param pointBY The y value of point B
	 * @return The minimum x coordinate between points A and B
	 */
	public static double getMinX(double pointAX, double pointAY, double pointBX, double pointBY)
	{
		if (pointAX > pointBX)
		{
			return pointBX;
		}
		else
		{
			return pointAX;
		}
	}
}













