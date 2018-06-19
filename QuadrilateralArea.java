/**
 * Finds the area of quadrilaterals under a curve given various coordinates
 * @author Tony Yang
 * @version 1.14.18
 */
import java.util.Scanner;
public class QuadrilateralArea
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int area = 0;
        int count = input.nextInt();
        int[] xvalues = new int[count];
        int[] yvalues = new int[count];
        for (int i = 0; i < count; i++)
        {
            int xcoord = input.nextInt();
            int ycoord = input.nextInt();
            xvalues[i] = xcoord;
            yvalues[i] = ycoord;
        }  
        
        for (int i = 1; i < count; i++)
        {
            area += findArea(xvalues [i - 1], yvalues[i - 1], xvalues [i], yvalues[i]);
        }   
        System.out.println(area);
        input.close();
    }        
    
    /**
     * Calculates the area of a quadrilateral through the coordinates (x1, y1) and (x2, y2)
     * @return The area of the quadrilateral
     */
    public static int findArea(int x1, int y1, int x2, int y2)
    {
        int calcArea = 0;
        calcArea = ((y1 + y2) * (x2 - x1)) / 2;
        return Math.abs(calcArea);
    }
}
