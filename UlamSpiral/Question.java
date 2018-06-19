/**
 * Represents a simple math question
 * @author Chris, Sherrie, Tony, Haley
 * @version 12.08.17
 */
public class Question
{
	private String displayText;
	private int correct;

	/**
	 * Create a question given the {@code displayText}, and the {@code correct} answer
	 * @param displayText the text to prompt the user with when the question is asked
	 * @param correct the correct answer to the question
	 */
	public Question(String displayText, int correct)
	{
		this.displayText = displayText;
		this.correct = correct;
	}

	/**
	 * Evaluate if a given answer is correct
	 * @param given the response provided by the user
	 * @return if the answer specified by {@code given} is correct
	 */
	public boolean validate(int given)
	{
		return correct == given;
	}

	/**
	 * Return the question prompt
	 * @return the question prompt
	 */
	public String getDisplayText()
	{
		return displayText;
	}

	/**
	 * Return a question as a string
	 * @return the question as a string
	 */
	public String toString()
	{
		return displayText;
	}
}
