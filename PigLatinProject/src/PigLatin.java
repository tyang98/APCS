import java.util.*;

/**
 * Converts a single phrase from English to Pig Latin
 * @author Tony and Jeff
 * @version 5.15
 */
public class PigLatin
{
	public final static String[] vowels = {"a", "e", "i", "o", "u", "y"};
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		s = convertPhrase(s);
		System.out.println(s);
		input.close();
	}
	
	public static String convertPhrase(String phrase)
	{
		String[] words = phrase.split(" ");
		String ret = "";
		for (int i = 0; i < words.length; i++)
		{
			ret += translate(words[i]) + " ";
		}
		return ret;
	}
	
	private static String translate(String word)
	{
		int index = 0;
		boolean foundVowel = false;
		while (!foundVowel && index < word.length())
		{
			String charAtIndex = word.substring(index, index + 1);
			for (String str : vowels)
				if (str.equals(charAtIndex))
					foundVowel = true;
			if (!foundVowel)
				index++;
		}
		String ret = word.substring(index);
		if (index == 0)
			ret += "yay";
		else
			ret += word.substring(0, index) + "ay";
		return ret;
	}
}
