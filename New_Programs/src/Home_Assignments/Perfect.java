package Home_Assignments;

import java.util.Scanner;

public class Perfect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number :");
		int n=sc.nextInt();
		int sum=0;
		for(int i=1;i<n;i++)
		{
			if (n%i==0)
			{
				sum=sum+i;
			}
		}
		if (sum==n)
		{
			System.out.println("Entered number is a perfect number");
		}
		else
		{
			System.out.println("Entered number is not a perfect number");
		}
	}

}
