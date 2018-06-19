import java.util.Scanner;

/**
 * Prompts users with questions and record responses
 * @author Chris, Sherrie, Hayley, Tony
 * @version 12.07.17
 */
public class QuestionDisplay
{
	private int counter;
	
	/**
	 * Displays and records questions
	 */
	public QuestionDisplay()
	{
		this.counter = 1;
	}
	
	/**
	 * Allows user to respond to question
	 */
	public int getUserResponse()
	{
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		sc.close();
		return temp;
	}
	
	/**
	 * Displays the question to user
	 * @param q The string representation of the question asked to user
	 */
	public void displayQuestion(String q)
	{
		
		System.out.println("-----------------------------");
		
		System.out.println("Question Number: " + counter);
		System.out.print(q);
		counter++;
 	}
	
	/**
	 * Displays message when answer is correct
	 */
 	public void promptSuccess()
	{
		System.out.println("Correct!");
	}
	
	/**
	 * Displays message when answer is incorrect
	 */
	public void promptFailure()
	{
		System.out.println("Incorrect.");
	}
}	
