/**
 * Simulates a matrix
 * @author Tony Yang
 * @version 1.11.18
 */
public class Matrix 
{

	private double[][] mat;
	
	/**
	 * Creates a matrix of any dimension
	 * @param mat The matrix that is being created
	 */
	public Matrix(double[][] mat)
	{
		this.mat = mat;
	}
	
	/**
	 * Returns element located at a given row and column
	 * @param row The row the element is in
	 * @param column The column the element is in
	 * @return The element located at a given row and column
	 */
	public double getElement(int row, int column)
	{
		double element = mat[row - 1][column - 1];
		return element;
	}
	
	/**
	 * Returns the entire matrix
	 * @return The entire matrix
	 */
	public Matrix getMatrix()
	{
		return new Matrix(mat);
	}
	
	
	/**
	 * Finds the certain row of a matrix
	 * @param row The row being returned by the matrix
	 * @return The row of a matrix
	 */
	public Matrix getRow(int row)
	{
		double[][] rows = new double[1][mat[0].length];
		for(int i = 0; i < mat[0].length; i++)
		{
			rows[0][i] = mat[row - 1][i];
		}
		return new Matrix (rows);		
	}
	
	/**
	 * Finds a certain column of a matrix
	 * @param column The column being returned by the matrix
	 * @return The column of a matrix
	 */
	public Matrix getColumn(int column)
	{
		double[][] columns = new double[mat.length][1];
		for(int i = 0; i < mat.length; i++)
		{
			columns[i][0] = mat[i][column - 1];
		}
		return new Matrix (columns);
	}
	
	/**
	 * Calculates the determinant of a 2 x 2 or 3 x 3 matrix
	 * @return The determinant of a 2 x 2 or 3 x 3 matrix
	 */
	public double getDeterminant()
	{
		double determinant = 0;
		double square1 = 0.0;
		double square2 = 0.0;
		double sides = 0.0;
		
		if (mat.length != mat[0].length)
		{
			System.out.println("The determinant cannot be calculated!");
		}
		else if (mat.length == 2 && mat[0].length == 2)
		{
			determinant = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
		}
		else if (mat.length == 3 && mat[0].length == 3)
		{
			square1 = (mat[1][1] * mat[2][2]) - (mat[1][2] * mat[2][1]);
			square2 =  (mat[1][0] * mat[2][1]) - (mat[1][1] * mat[2][0]);
			sides =  (mat[1][0] * mat[2][2]) - (mat[1][2] * mat[2][0]);
			determinant = (mat[0][0] * square1) - (mat[0][1] * sides) + (mat[0][2] * square2);
		}
		return determinant;
	}
	
	/**
	 * Calculates the area of a triangle with a the determinant of a 3 x 3 matrix
	 * @returns The area of a triangle
	 */
	public double getArea()
	{
		double determinant = 0;
		double square1 = 0.0;
		double square2 = 0.0;
		double sides = 0.0;
		double area = 0.0; 
		
		if (mat.length != 3 && mat[0].length != 3)
		{
			System.out.println("The area cannot be calculated");
		}
		else if (mat.length == 3 && mat[0].length == 3)
		{
			square1 = (mat[1][1] * mat[2][2]) - (mat[1][2] * mat[2][1]);
			square2 =  (mat[1][0] * mat[2][1]) - (mat[1][1] * mat[2][0]);
			sides =  (mat[1][0] * mat[2][2]) - (mat[1][2] * mat[2][0]);
			determinant = (mat[0][0] * square1) - (mat[0][1] * sides) + (mat[0][2] * square2);
		}
		area = 0.5 * Math.abs(determinant);
		return area;
		
	}
	/**
	 * Calculates the values of a matrix after scalar multiplication
	 * @param constant The value the matrix is multiplied by
	 * @return The matrix that is multiplied by the constant
	 */
	public Matrix scalarMultiply(int constant)
	{
		double[][] temp = new double[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[0].length; j++)
			{
				temp[i][j] = constant * mat[i][j];
			}
		}
		return new Matrix (temp);
	}
	
	/**
	 * Returns the diagonal values of a square matrix starting from the right
	 * @return The values of the diagonals in a square matrix
	 * Precondition: Matrix must be a square matrix
	 */
	public Matrix getRightDiag()
	{
		double[][] temp = new double[1][mat.length];
		for (int i = 0; i < mat.length; i++)
		{
			temp[0][i] = mat[i][i];
		}
		return new Matrix (temp);
	}
	
	/**
	 * Returns the diagonal values of a square matrix starting from the left
	 * @return The values of the diagonals in a square matrix
	 * Precondition: Matrix must be a square matrix
	 */
	public Matrix getLeftDiag() {
		double[][] temp = new double[1][mat.length];
		for (int i = 0; i < mat.length; i++)
		{
			temp[0][i] = mat[i][mat.length - i - 1];
		}
		return new Matrix (temp);
	}
	
	/** 
	 * Checks if the Matrix are the same
	 * @return The true or false depending on whether the matrices are the same
	 */
	public boolean equals(double[][] mat1)
	{
		boolean equal = false;
		if (mat.length != mat1.length && mat[0].length != mat1[0].length)
		{
			equal = false;
		}
		else
		{	for( int i = 0; i < mat.length; i++)
			{
				for(int j = 0; j < mat[0].length; j++)
				{
					if (this.mat[i][j] == mat1[i][j])
					{
						equal = true;
					}
					equal = false;
				}
			}
		}
		return equal;
	}
	/**
	 * Returns the matrix as a string
	 * @return The matrix as a string
	 */
	public String toString()
	{
		String output = "";
		for( int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat[0].length; j++)
			{
				output += "" + mat[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}
		
}
