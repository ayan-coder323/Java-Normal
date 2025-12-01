package Skill_Programs;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the weight of the body in kg :");
		int weight=sc.nextInt();
		System.out.println("Enter height of the body in metres : ");
		int height=sc.nextInt();
		int bmi=weight/(height*height);
		System.out.println("The BMI of your body is : "+bmi);
	}

}
