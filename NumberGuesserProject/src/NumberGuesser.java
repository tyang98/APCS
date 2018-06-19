import java.util.Scanner;

public class NumberGuesser
{
	public static Scanner input;
	public static int guesses;
	public static int number;
	public static boolean numberGuessed;
	
	public static void main(String[] args)
	{
		NumberGuesser test = new NumberGuesser();
		prompt();
	}
	
	public NumberGuesser()
	{
		numberGuessed = false;
		input = new Scanner(System.in);
		guesses = 0;
		number = (int) (Math.random() * 100) + 1;
	}
	
	public static void prompt()
	{
		System.out.println("Hello! Please play this number guessing game");
		System.out.println("Enter \"u\" for you to guess the computer's number or enter \"c\" for the computer to guess your number");
		String response = input.next();
		if (response.equals("u"))
		{
			userGuesser();
		}
		else if (response.equals("c"))
		{
			compGuesser(1, 100);
		}
		else
		{
			System.out.println("Error! Please enter the correct options!");
			prompt();
		}
	}
	
	public static String compGuesser(int low, int high)
	{
		int mid = (int) ((low + high) / 2.0);
		while (!numberGuessed)
		{
			System.out.println("Is " + mid + " higher, lower, or correct?");
			String response = input.next();
			if (response.equals("correct"))
			{
				numberGuessed = true;
				System.out.println("Good Job! You Guessed Right");
				guesses++;
			}
			else if (response.equals("higher"))
			{
				numberGuessed = false;
				guesses++;
				return compGuesser(mid, high);
			}
			else if (response.equals("lower"))
			{
				numberGuessed = false;
				guesses++;
				return compGuesser(low, mid);
			}
		}
		input.close();
		System.out.println("Total Guess Count: " + guesses);
		return "";
	}
	
	public static void userGuesser()
	{
		while (!numberGuessed)
		{
			System.out.println("Guess the number I have chosen");
			int value = input.nextInt();
			if (value == number)
			{
				System.out.println("Good Job! You Guessed Right");
				numberGuessed = true;
				guesses++;
			}
			else if (value > number)
			{
				System.out.println("lower");
				numberGuessed = false;
				guesses++;
			}
			else
			{
				System.out.println("higher");
				numberGuessed = false;
				guesses++;
			}
			
		}
		System.out.println("Total Guess Count: " + guesses);
	}
	
}