package Skill_Programs;

import java.util.Arrays;
import java.util.Scanner;

public class Largest_Rowsum_Column_Sum {

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
		int rowsum[]=new int[r];
		int colsum[]=new int[c];
		for(int i=0;i<r;i++)
		{
			int rsum=0;
			for(int j=0;j<c;j++)
			{
				rsum+=matrix[i][j];
				rowsum[i]=rsum;
			}
			System.out.println("Row "+(i+1)+" sum value = "+rsum);
		}
		for(int j=0;j<c;j++)
		{
			 int csum=0;
			for(int i=0;i<r;i++)
			{
				csum+=matrix[i][j];
				colsum[j]=csum;
			}
			System.out.println("Column "+(j+1)+" sum value = "+csum);		
		}
		Arrays.sort(rowsum);
		Arrays.sort(colsum);
		System.out.println("The maximum out of the row sums is : "+rowsum[r-1]);
		System.out.println("The maximum out of the column sums is : "+colsum[c-1]);
	}

}
