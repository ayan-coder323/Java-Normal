package Demo_Programs;
import java.util.*;

public class Matrix_multiply {

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
		int multiply[][]=new int[r1][c2];
		if (c1==r2)
		{
			for(int i=0;i<r1;i++)
			{
				for(int j=0;j<c2;j++)
				{
					multiply[i][j]=0;
					for(int k=0;k<c1;k++)
					{
						multiply[i][j]+=matrix1[i][k]*matrix2[k][j];
					}
				}
			}
		}
		else
		{
			System.out.println("Matrix multiplication is not possible ");
		}
		System.out.println("Displaying the new array :");
		for (int i=0;i<r1;i++)
		{
			for (int j=0;j<c2;j++)
			{
				System.out.print(multiply[i][j]+"  ");
			}
			System.out.println();
		}

	}

}
