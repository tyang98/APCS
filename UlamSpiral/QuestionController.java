import java.util.Scanner;

/**
 * Outputs and generates a question for the user
 * @author Chris, Sherrie, Tony, Hayley
 * @version 12.08.17
 */
public class QuestionController 
{

	public static void main(String[] args)
	{
		int currentPoints = 0;
		Scanner sc = new Scanner(System.in);
		Level generator = new Level(Level.EASY_DIFFICULTY);
		String prompt;
		QuestionDisplay disp = new QuestionDisplay();

		while ((prompt = generator.getCurQuestonText()) != null)		//Temp, assume user wants to play forever
		{
			//Inform user of current points
			System.out.println("Current Score: " + currentPoints);

			disp.displayQuestion(prompt);		//Prompt the user with the question to ask

			//Here read responses
			boolean getsSecondTry = true;
			int attemptNum = 1;
			while (getsSecondTry)
			{
				int response = sc.nextInt();			//Read user response here, already been prompted

				if(generator.validateAgainstCur(response))
				{
					getsSecondTry = false;
					disp.promptSuccess();
					currentPoints++;
				}
				else if (attemptNum >= 2)
				{
					disp.promptFailure();
					getsSecondTry = false;
				}
				else
				{
					attemptNum++;
					disp.promptFailure();
				}
			}

			if (currentPoints == 5)
			{
				System.out.println("Increasing to medium difficulty.");
				generator.setLevel(Level.MEDIUM_DIFFICULTY);
			}
			else if (currentPoints == 10)
			{
				System.out.println("Increasing to hard difficulty.");
				generator.setLevel(Level.HARD_DIFFICULTY);
			}

			generator.newQuestion();
		}	
	}
}
