package KLU;

import java.util.Scanner;

class Electricity{
	int units;
	double bill;
	void inputUNits()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter units consumed :");
		units=sc.nextInt();
	}
	
	
	void display()
	{
		System.out.println("Electricity bill :"+bill);
	}
	
	
	void Calc()
	{
		if (units<100)
		{
			bill=units*5;
		}
		else if(units >100 && units <=200)
		{
			bill=100*5+(units-100)*7.5;
		}
		else
		{
			bill=100*5+(100*7.5)+(units-200)*10;
		}
	}
}
	
public class Electricity_Bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Electricity ob=new Electricity();
		ob.inputUNits();
		ob.Calc();
		ob.display();
	}
}