/**
 * Tests the Matrix class and MatrixMath class
 * @author Tony Yang
 * @version 1.11.18
 */
public class MatrixTester {
	public static void main(String[] args)
	{
		double[][] matrix1 = { {3, -5},
							 { 2, 6},}; 
		double[][] matrix2 = { {1, 1, 1},
							 { 1, 6, 7},
							 { 1, 7 ,3},};
		double[][] matrix3 = {{3, 5 },
							 { -2, 6},
							 {1, 8},};
		double[][] matrix4 = {{3, 1 },
				 			 { -1, 7},
				 			 {1, 5},};
						
		Matrix m1 = new Matrix(matrix1);
		Matrix m2 = new Matrix(matrix2);
		Matrix m3 = new Matrix(matrix3);
		Matrix m4 = new Matrix(matrix4);
		System.out.println("Matrix 1: ");
		System.out.println(m1);
		System.out.println("M1's value at row 2 and column 1");
		System.out.println(m1.getElement(2, 1));
		System.out.println();
		System.out.println("Row 2");
		System.out.println(m1.getRow(2));
		System.out.println("Column 1");
		System.out.println(m1.getColumn(1));
		System.out.println("Matrix after multiplication by -3");
		System.out.println(m1.scalarMultiply(-3));
		System.out.println("Determinant: ");
		System.out.println(m1.getDeterminant());
		System.out.println("-----------------------");
		System.out.println("Matrix 2: ");
		System.out.println(m2);
		System.out.println("M2's Right Side Diagonal Values");
		System.out.println(m2.getRightDiag());
		System.out.println("M2's Left Side Diagonal Values");
		System.out.println(m2.getLeftDiag());
		System.out.println("Determinant: ");
		System.out.println(m2.getDeterminant());
		System.out.println();
		System.out.println("Area of triangle with coordinates at (1,1), (6,7), (7,3)");
		System.out.println(m2.getArea());
		System.out.println();
		System.out.println("Check if Matrix 1 and Matrix 2 are the same:");
		System.out.println(m1.equals(m2));
		System.out.println("-------------------------------");
		System.out.println("Matrix Computations");
		System.out.println("Matrix 3");
		System.out.println(m3.getMatrix());
		System.out.println("Matrix 4");
		System.out.println(m4);
		System.out.println("Add matrix 3 by matrix 4");
		System.out.println(MatrixMath.add(matrix3, matrix4));
		System.out.println("Add matrix 1 by matrix 2");
		System.out.println(MatrixMath.add(matrix1, matrix2));
		System.out.println();
		System.out.println("Subtract matrix 3 by matrix 4");
		System.out.println(MatrixMath.add(matrix3, matrix4));
		System.out.println("Multiply matrix 2 by matrix 3");
		System.out.println(MatrixMath.multiply(matrix2, matrix3));
	}
		
}
