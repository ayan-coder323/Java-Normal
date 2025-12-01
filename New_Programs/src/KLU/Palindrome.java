package KLU;

import java.util.Scanner;


import java.math.*;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=sc.nextInt();
		int c=0;
		if (n<0)
		{
			n=Math.abs(n);
			c=1;
		}
		int a=n,rev=0;
		while (a>0)
		{
			rev=(rev*10)+a%10;
			a=a/10;
		}
		if (rev==n && c!=1)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		

	}

}
