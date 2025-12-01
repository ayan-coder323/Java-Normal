package Home_Assignments;

import java.util.Scanner;

public class RowSum_ColumnSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows of the matrix ");
		int r=sc.nextInt();
		System.out.println("Enter the number of columns of the matrix ");
		int c=sc.nextInt();
		int matrix[][]=new int[r][c];
		System.out.println("Enter the elements of the matrix ");
		for (int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		int rowsum=0;
		int colsum=0;
		for(int i=0;i<r;i++)
		{
			rowsum=0;
			for(int j=0;j<c;j++)
			{
				rowsum+=matrix[i][j];
			}
			System.out.println("Row "+(i+1)+" sum value = "+rowsum);
		}
		for(int j=0;j<c;j++)
		{
			colsum=0;
			for(int i=0;i<r;i++)
			{
				colsum+=matrix[i][j];
			}
			System.out.println("Column "+(j+1)+" sum value = "+colsum);		
		}
	}

}
