package Home_Assignments;

import java.util.Scanner;

class Circle
{
	double r,pi=3.14;
	void input()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the radius of the circle ");
		r=sc.nextDouble();
	}
	void Calc()
	{
		System.out.println("The area of circle is : "+(pi*r*r));
		System.out.println("The circumference of the circle is "+(2*pi*r));
	}
}


public class Circle_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c=new Circle();
		c.input();
		c.Calc();
	}

}
