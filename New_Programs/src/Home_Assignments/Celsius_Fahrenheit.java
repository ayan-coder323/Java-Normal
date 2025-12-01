package Home_Assignments;
import java.util.*;
public class Celsius_Fahrenheit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String c;
		do {
		System.out.println("Press\n1. For Conversion from Celcius to Fahrenheit\n2. For conversion from Fahrenheit to Celcius and\n3. Celcius to Kelvin");
		int ch=sc.nextInt();
		if (ch==1)
		{
			System.out.println("Enter the temperature in Celcius Scale :");
			int temp=sc.nextInt();
			double fah=(temp*9/5)+32;
			System.out.println("The temperature in Fahrenheit scale is "+fah);
		}
		else if(ch==2)
		{
			System.out.println("Enter the temperature in Fahrenheit Scale :");
			int temp=sc.nextInt();
			double cel=(temp-32)*5/9;
			System.out.println("The temperature in Celcius scale is "+cel);
		}
		else if(ch==3)
		{
			System.out.println("Enter the temperature in Celcius Scale :");
			int temp=sc.nextInt();
			double kel=temp+273.15;
			System.out.println("The temperature in Kelvin scale is "+kel);
		}
		else
		{
			System.out.println("Invalid choice Bro Try Again.................");
		}
		System.out.println("Enter Y for another choice and N for exit");
		c=sc.next();
		}while(c.equalsIgnoreCase("Y"));
	}

}
