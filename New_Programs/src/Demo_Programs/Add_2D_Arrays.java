package Demo_Programs;
import java.util.Scanner;

public class Add_2D_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows for the first matrix ");
		int r1=sc.nextInt();
		System.out.println("Enter the number of columns for the first matrix ");
		int c1=sc.nextInt();
		int matrix1[][]=new int[r1][c1];
		System.out.println("Enter the elements of the first matrix ");
		for (int i=0;i<r1;i++)
		{
			for(int j=0;j<c1;j++)
			{
				matrix1[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the number of rows for the second matrix ");
		int r2=sc.nextInt();
		System.out.println("Enter the number of columns for the second matrix ");
		int c2=sc.nextInt();
		System.out.println("Enter the elements of the second matrix ");
		int matrix2[][]=new int[r2][c2];
		for (int i=0;i<r2;i++)
		{
			for(int j=0;j<c2;j++)
			{
				matrix2[i][j]=sc.nextInt();
			}
		}
		if (r1==r2 && c1==c2)
		{
			int add[][]=new int[r1][c1];
			for(int i=0;i<r1;i++)
			{
				for (int j=0;j<c1;j++)
				{
					add[i][j]=matrix1[i][j]+matrix2[i][j];
				}
			}
			System.out.println("The new matrix after addition is :");
			for(int i=0;i<r1;i++)
			{
				for (int j=0;j<c1;j++)
				{
					System.out.print(add[i][j]+"  ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("Addition not possible");
		}

	}
}
