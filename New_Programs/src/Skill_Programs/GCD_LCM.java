package Skill_Programs;

import java.util.Scanner;

public class GCD_LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int lcm,r=0;
		int pro=a*b;
		while(b>0)
		{
			r=a%b;
			a=b;
			b=r;
		}
		System.out.println("GCD = "+a);
		System.out.println("LCM = "+pro/a);
	}

}
