package Skill_Programs;

import java.util.Scanner;

public class Arms_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Armstrong numbers between 1 and 1000 are : ");
		int i=1;
		while(i<=1000)
		{
			int a=i,s=0;
			while(a>0)
			{
				s=s+(int)Math.pow(a%10, 3);
				a=a/10;
			}
			if (s==i)
			{
				System.out.println(i);
			}
			i++;
		}

	}

}
