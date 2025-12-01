package Lab_Programs;

import java.util.Scanner;

public class Basic_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers :");
		int a=sc.nextInt();
		int b=sc.nextInt();
		String c;
		System.out.println("1.Press 1 for Addition\n2.Press 2 for Subtraction\n3.Press 3 for Product\n4.Press 4 for Quotient\n5.Press 5 for Remainder");
		System.out.println("Enter your choice : ");
		int ch=sc.nextInt();
		do {
			if (ch==1)
			{
				System.out.println("Addition result : "+(a+b));
			}
			if (ch==2)
			{
				System.out.println("Subtraction result : "+(a-b));
			}
			if (ch==3)
			{
				System.out.println("Product result : "+(a*b));
			}
			if (ch==4)
			{
				System.out.println("Quotient result : "+(a/b));
			}
			if (ch==5)
			{
			System.out.println("Remainder result : "+(a%b));
			}
			System.out.println("Enter Y for another choice and N for exit");
			c=sc.next();
		}while(c.equalsIgnoreCase("Y"));

	}

}
