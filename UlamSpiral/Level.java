/**
 * Represents a level of difficulty
 * @author Chris, Sherrie, Tony, Haley
 * @version 12.08.17
 */
public class Level
{
	/**
	 * Integer code for easy difficulty
	 */
	public static final int EASY_DIFFICULTY = 1;

	/**
	 * Integer code for medium difficulty
	 */
	public static final int MEDIUM_DIFFICULTY = 2;

	/**
	 * Integer code for hard difficulty
	 */
	public static final int HARD_DIFFICULTY = 3;

	private int level;
	private Question current;
	

	/**
	 * Create a level given the difficulty level
	 * @param level the difficulty level between 1 and 3
	 * @throws IllegalArgumentException if the given difficulty is less than 1 or greater than 3
	 */
	public Level(int level)
	{
		if(level < 1 || level > 3)
		{
			throw new IllegalArgumentException("The difficulty level must be greater than zero and less than three");
		}
		this.level = level;
		newQuestion();
	}
	
	/**
	 * Creates a new question based on the current difficulty
	 */
	public void newQuestion()
	{
		Question q;
		
		if (level == 1)
		{
			int t1 = betterRand(1, 8);
			int t2 = betterRand(1, 9 - t1);
			q = new Question(t1 + "+" + t2, t1 + t2);
		}
		else if (level == 2)
		{
			int t1 = betterRand(1, 9);
			int t2 = betterRand(1, 9);
			q = new Question(t1 + "+" + t2, t1 + t2);
		}
		else if (level == 3)
		{
			int t1 = betterRand(1, 9);
			int t2 = betterRand(1, t1);
			q = new Question(t1 + "-" + t2, t1 - t2);
		}
		else
		{
			q = new Question("Error creating question", 0);
		}
		
		this.current = q;
	}
	
	/**
	 * Return the string representation of the current question of the level
	 * @return the string representation of the current question of the level
	 */
	public String getCurQuestonText()
	{
		return current.getDisplayText();
	}
	
	/**
	 * Validate the given response against the current question
	 * @param response the response to validate
	 * @return if the given response matches the accepted response
	 */
	public boolean validateAgainstCur(int response)
	{
		return current.validate(response);
	}
	
	/**
	 * Update the level of the Level class to {@code newLevel}
	 * @param newLevel the difficulty level to set the level to
	 * @throws IllegalArgumentException if the level is less than 1 or greater than 3
	 */
	public void setLevel(int newLevel)
	{
		if(newLevel < 1 || newLevel > 3)
		{
			throw new IllegalArgumentException("The difficulty level must be greater than zero and less than three");
		}
		this.level = newLevel;
	}
	
	private static int betterRand(int min, int max)
	{
		return ((int)(Math.random() * (max - min + 1))) + min;
	}
}
