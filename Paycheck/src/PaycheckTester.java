import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * Tests the Paycheck class
 * @author Tony Yang
 * @version 10.16.17
 */
public class PaycheckTester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter("Paycheck.txt");
        boolean paycheckGeneration = true;
        
        while(paycheckGeneration)
        {
            System.out.println("Enter employee name: ");
            String name = input.next();
            out.println("Enter employee name: " + name);
            System.out.println("Enter the number of hours worked: ");
            double hours = input.nextDouble();
            out.println("Enter the number of hours worked: " + hours);
            System.out.println("Enter your wage: ");
            double wage = input.nextDouble();
            out.println("Enter your wage: " + wage);
            
            Paycheck pc1 = new Paycheck(name, hours, wage );
            double finalpaycheck = pc1.getFinalAmount();
            System.out.println(String.format("Your Paycheck: $%.2f", finalpaycheck));
            out.println(String.format("Your Paycheck: $%.2f", finalpaycheck));
            System.out.println();
            System.out.println("Type \"Yes\" for a new paycheck. Type \"No\" to exit.");
            String response = input.next();
            
            if (response.equals("Yes"))
            {
                paycheckGeneration = true;
            }
            else
            {
                paycheckGeneration = false;
                out.close();
            }
        } 
        input.close();
    }  
}


