package Lab_Programs;

import java.util.Scanner;

public class Reverse_3_Digit_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=sc.nextInt();
		int rev=0,a=n;
		while(a>0)
		{
			rev=rev*10+(a%10);
			a=a/10;
		}
		System.out.println("The reverse of the number is : "+rev);
	}

}
