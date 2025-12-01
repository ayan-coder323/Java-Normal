package KLU;

import java.util.Scanner;

public class Jagged {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of rows of the matrix :");
		int rows=sc.nextInt();
		int ar[][]=new int[rows][];
		int colsize=0;
		for(int i=0;i<rows;i++)
		{
			System.out.println("Enter size of row "+(i+1));
			colsize=sc.nextInt();
			ar[i]=new int[colsize];
			System.out.println("Enter "+(colsize)+" elements");
			for( int j=0;j<colsize;j++)
			{
				ar[i][j]=sc.nextInt();
			}
		}
		System.out.println("The 2D array is :");
		for (int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[i].length;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}

}
