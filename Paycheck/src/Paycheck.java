import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Simulates writing a paycheck for an employee
 * @author Tony Yang
 * @version 10.16.17
 */
public class Paycheck
{
   private String myName;
   private double myHours;
   private double myWage;
   private double myFinalAmount;
   final static double MAX_HOURS = 40.0;
   final static double OVERTIME = 1.50;
   
   /**
    * Creates a paycheck for an employee given name, hours, and wage
    * @param name The name of the employee
    * @param wage The wage of employee 
    * @param hours The number of hours worked
    * @throws FileNotFoundException
    */
   public Paycheck(String name, double hours, double wage) throws FileNotFoundException
   {
       myName = name;
       myHours = hours;
       myWage = wage;
       myFinalAmount = 0;
   }
   
   /**
     * Returns employee name
     * @return The employee name
     * @throws FileNotFoundException
     */
    public String getName() throws FileNotFoundException
    {
        return myName;
    }
    
   /**
     * Returns hourly wage
     * @return The hourly wage
     * @throws FileNotFoundException
     */
    public double getWage() throws FileNotFoundException
   {
        return myWage;
   }

    /**
     * Returns number of hours worked
     * @return The number of hours worked
     * @throws FileNotFoundException
     */
   public double getHours() throws FileNotFoundException
   {
       return myHours;
   }
   
   /**
    * Returns the final paycheck amount
    * @returns The final paycheck amount
    * @throws FileNotFoundException
    */
   public double getFinalAmount() throws FileNotFoundException
   {
       if (myHours > 40)
       {
           myFinalAmount = (MAX_HOURS * myWage) + ((myHours - MAX_HOURS) * (OVERTIME * myWage));
           return myFinalAmount;
       }
       else
       {
           myFinalAmount = myHours * myWage;
           return myFinalAmount;
       }
   }
   
}

