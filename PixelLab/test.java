import java.util.*;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
	int list = 0;
	boolean isFirst = true;
	int num = input.nextInt();
		
	if (num % 2 == 0)
	{
		for(int i = 1; i <= num; i++ )
		{
			if (isFirst)
			{
			    list = num * num;
			    isFirst = false;
			}
			System.out.print(list + " ");
			list -= 1;
		}
	}
	else
	{	
	    for(int i = 1; i <= num; i++ )
	    {
	        if (isFirst)
	        {
	            list = ((int) Math.pow(num - 1, 2) + 1);
	            isFirst = false;
 		}
 		System.out.print(list + " ");
 		list -= 1;
            }
	}
	input.close();
    }
}

