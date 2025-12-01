package Skill_Programs;

import java.util.Scanner;

public class GST_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount you have spent :");
		int price=sc.nextInt();
		System.out.println("Enter the discount percentage you want : ");
		double dis=sc.nextInt();
		double newprice=price-(price*(dis/100));
		double gst=0.18;
		System.out.println("The final amount you need to pay is "+(newprice+(newprice*gst)));
	}
}
