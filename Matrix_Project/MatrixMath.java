/**
 * Simulates matrix computations with two matrices.
 * @author Tony Yang
 * @version 1.11.18
 */
public class MatrixMath
{
	/**
	 * Adds two matrices of the same size together
	 * @param mat1 The first matrix 
	 * @param mat2 The second matrix
	 * @return The matrix formed when mat1 adds mat2
	 */
	public static Matrix add(double mat1[][], double mat2[][])
	{
		double[][] temp = new double[mat1.length][mat1[0].length];
		if (mat1.length == mat2.length && mat1[0].length == mat2[0].length )
		{
			for (int i = 0; i < mat1.length; i++)
			{
				for (int j = 0; j < mat1[0].length; j++)
				{
					temp[i][j] = mat1[i][j] + mat2[i][j];
				}
			}	
			
		}
		else
		{
			System.out.print("These matrices cannot be added!");
			System.out.println();
			return null;
		}
		return new Matrix (temp);
		
	}
	
	/**
	 * Subtract two matrices of the same size
	 * @param mat1 The first matrix 
	 * @param mat2 The second matrix
	 * @return The matrix formed when mat1 subtracts mat2
	 */
	public static Matrix subtract(double[][] mat1, double[][] mat2)
	{
		double[][] temp = new double[mat1.length][mat1[0].length];
		if (mat1.length == mat2.length && mat1[0].length == mat2[0].length )
		{
			for (int i = 0; i < mat1.length; i++)
			{
				for (int j = 0; j < mat1[0].length; j++)
				{
					temp[i][j] = mat1[i][j] - mat2[i][j];
				}
			}
		}
		else
		{
			System.out.print("These matrices cannot be subtracted!");
			System.out.println();
			return null;
		}
		return new Matrix (temp);
	}
	
	/**
	 * Multiply matrices together to form a new matrix
	 * @param mat1 The first matrix 
	 * @param mat2 The second matrix
	 * @return The matrix formed when mat1 is multiplied by mat2
	 */
	public static Matrix multiply(double mat1[][], double mat2[][])
	{
		double[][] temp = new double[mat1.length][mat2[0].length];
		if (mat1[0].length == mat2.length)
		{
			for(int i = 0; i < mat1.length; i++)
			{
				for(int j = 0; j < mat2[0].length; j++)
				{
					for (int a = 0; a < mat2.length; a++)
					{
						temp[i][j] += mat1[i][a] * mat2[a][j];
					}
				}
			}
		}
		else
		{
			System.out.println("These two matrices cannot be multiplied!");
			System.out.println();
			return null;
		}
		return new Matrix (temp);
	}
	
	
}
	
