package Home_Assignments;

import java.util.Scanner;

class Rectangle
{
	int l,b;
	void input()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the length and breadth of the rectangle ");
		l=sc.nextInt();
		b=sc.nextInt();
	}
	void Calc()
	{
		System.out.println("The area of the rectangle is : "+(l*b));
		System.out.println("The perimeter of the rectangle is : "+(2*(l+b)));
	}
}

public class Rectangle_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle=new Rectangle();
		rectangle.input();
		rectangle.Calc();
	}

}
