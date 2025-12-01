package Home_Assignments;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a number :");
		int n=sc.nextInt();
		
		int a=n,arm=0;
		while(a>0)
		{
			 arm=(int) (arm+Math.pow((a%10),3));
			 a=a/10;
		}
		
		
		if (arm==n)
		{
			System.out.println("Entered number is an Armstrong Number ");
		}
		else
		{
			System.out.println("Entered number is not an Armstrong Number ");
		}

	}

}
