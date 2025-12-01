package Home_Assignments;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 5 values whose average needs to be calculated :");
		
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		int e=sc.nextInt();
		
		
		System.out.println("The Average of the five numbers entered "+(float)(a+b+c+d+e)/5);
	}

}
