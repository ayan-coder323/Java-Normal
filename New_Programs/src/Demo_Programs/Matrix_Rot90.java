package Demo_Programs;

import java.util.Scanner;

public class Matrix_Rot90 {

	public static void main(String[] args) {
				// TODO Auto-generated method stub
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the rows of the matrix :");
				int r=sc.nextInt();
				System.out.println("Enter the no of columns :");
				int c=sc.nextInt();
				System.out.println("Enter the elemnts of the array :");
				int a[][]=new int[r][c];
				for (int i=0;i<r;i++)
				{
					for(int j=0;j<c;j++)
					{
						a[i][j]=sc.nextInt();
					}
				}
				for (int i=0;i<c;i++)
				{
					for(int j=i+1;j<r;j++)
					{
						int t=a[i][j];
						a[i][j]=a[j][i];
						a[j][i]=t;
					}
				}
				System.out.println("The transpose of the matrix is :");
				for (int i=0;i<r;i++)
				{
					for(int j=0;j<c;j++)
					{
						System.out.print(a[i][j]+"  ");
					}
					System.out.println();
				}
				for (int i=0;i<r;i++)
				{
					int left=0,right=r-1;
					while(left<right)
					{
						int t=0;
						t=a[i][left];
						a[i][left]=a[i][right];
						a[i][right]=t;
						left++;
						right--;
					}
				}
				System.out.println("Now the matrix rotated by 90 degress is :");
				for (int i=0;i<r;i++)
				{
					for(int j=0;j<c;j++)
					{
						System.out.print(a[i][j]+"  ");
					}
					System.out.println();
				}
				
	}
}
