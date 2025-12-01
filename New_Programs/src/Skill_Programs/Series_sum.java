package Skill_Programs;

import java.util.Scanner;

public class Series_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of terms : ");
		int n=sc.nextInt();
		int s=0;
		for (int i=1;i<=n;i++)
		{
			if (i==n)
			{
				System.out.print(i*i);
				 s=s+i*i;
			}
			else
			{
				System.out.print(i*i+"+");
				 s=s+i*i;
			}
		}
		System.out.println();
		System.out.println("Sum of the series "+s);

	}

}
