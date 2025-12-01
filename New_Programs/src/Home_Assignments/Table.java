package Home_Assignments;

import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number whose table you want to see :");
		int n=sc.nextInt();
		System.out.println("Enter the limit value upto which you want to see the table :");
		int limit=sc.nextInt();
		for(int i=1;i<=limit;i++)
		{
			System.out.println(n+" * "+i+" = "+n*i);
		}

	}

}
