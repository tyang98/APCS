/**
 * Creates and tests an integer reverser
 * @author Tony Yang
 * @version 11.20.17
 */
public class ReverseSpecs
{
	
	public static void main(String[] args)
	{
		Integer test = new Integer(853025);
		Integer test1 = new Integer(214748640);
		System.out.println(reverse(test));
		System.out.println(reverse(test1));
	}
	
	/**
	 * Reverses an integer's numbers.
	 * @param num The integer that is going reversed
	 * @return The num that is reversed
	 */
	public static Integer reverse(Integer num)
	{
		int[] numList = new int[(int)Math.log10(num) + 1];
		int counter = 1;
		int numMarker = numList.length - 1;
		String reverseNum = "";
		while (counter <= num)
		{
			numList[numMarker] = num / counter % 10;
			counter *= 10;
			numMarker--;
		}
		for (int i = numList.length - 1; i >= 0; i--)
		{
			reverseNum += "" + numList[i]; 
		}
		return Integer.parseInt(reverseNum);
	}
	
}