package Lab_Programs;

import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=sc.nextInt();
		System.out.println("The factors of "+n+" are :");
		int i=1;
		while(i<=n)
		{
			if (n%i==0)
			{
				System.out.println(i);
			}
			i++;
		}
	}

}
