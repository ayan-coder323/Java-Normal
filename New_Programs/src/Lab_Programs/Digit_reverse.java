package Lab_Programs;

import java.util.Scanner;

public class Digit_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=sc.nextInt();
		int s=0;
		while(n>0)
		{
			s=s+(n%10);
			n=n/10;
		}
		System.out.println("The sum of the digits of the number is : "+s);
	}

}
