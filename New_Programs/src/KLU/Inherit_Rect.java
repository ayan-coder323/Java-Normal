package KLU;

import java.util.Scanner;


class shape
{
	protected double i;
	protected int l,b;
	shape(double s)
	{
		this.i=s;
	}
	shape(int a,int c)
	{
		this.l=a;
		this.b=c;
	}
	
}
class Squarearea extends shape
{
	Squarearea(double s)
	{
		super(s);
	}
	void Show()
	{
		System.out.println("Area = "+(i*i));
	}
}
class Rectarea extends shape
{
	Rectarea(int a,int b)
	{
		super(a,b);
	}
	void Show()
	{
		System.out.println("Area = "+(l*b));
	}
}
public class Inherit_Rect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("1.Press 1 for Square Area\n2.Press 2 for Rectangle area");
		System.out.println("Enter your choice : ");
		int ch=scanner.nextInt();
		if (ch==1)
		{
			System.out.println("Enter the side of the square :");
			Double s=scanner.nextDouble();
			Squarearea sq=new Squarearea(s);
			sq.Show();
		}
		else
		{
			System.out.println("Enter the length and breadth of the rectangle :");
			int l=scanner.nextInt();
			int b=scanner.nextInt();
			Rectarea r=new Rectarea(l, b);
			r.Show();
		}
		}

	}
