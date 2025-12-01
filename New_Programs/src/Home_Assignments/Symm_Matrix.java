package Home_Assignments;

import java.util.Scanner;

public class Symm_Matrix {

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
		if (r==c)
		{
			int count=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c;j++)
				{
					if(matrix[i][j]!=matrix[j][i])
					{
						count=1;
						break;
					}
				}
			}
			if (count==0)
			{
				System.out.println("The given matrix is a symmetric matrix");
			}
			else
			{
				System.out.println("The given matrix is not a symmetric matrix");
			}
		}
		else
		{
			System.out.println("Not a Square matrix");
		}
		sc.close();
	}

}
