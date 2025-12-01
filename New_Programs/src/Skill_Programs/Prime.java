package Skill_Programs;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=sc.nextInt();
		int p=2;
		int flg=0;
		while(p<=(int)Math.sqrt(n))
		{
			if (n%p==0)
			{
				flg=1;
				break;
			}
			p++;
		}
		if (flg==0)
		{
			System.out.println("Prime");
		}
		else
		{
			System.out.println("Not prime");
		}

	}

}
