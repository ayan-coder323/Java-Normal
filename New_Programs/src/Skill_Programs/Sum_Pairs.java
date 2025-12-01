package Skill_Programs;

import java.util.Scanner;

public class Sum_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the sum value : ");
		int sum=scanner.nextInt();
		int bottom=0,top=sum;
		while(bottom<=top)
		{
			if ((bottom+top)==sum)
			{
				System.out.print("("+bottom+",");
				System.out.print(top+")");
			}
			bottom++;
			top--;
			System.out.println();
		}

	}

}
