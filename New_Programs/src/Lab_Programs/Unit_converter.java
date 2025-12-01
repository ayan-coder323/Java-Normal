package Lab_Programs;

import java.util.Scanner;

import com.sun.security.auth.NTDomainPrincipal;

public class Unit_converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Unit Converter");
		System.out.println("1.Press 1 for conversion of centimetres to metres\n2.Press 2 for conversion of kilograms to grams\n3.Press 3 for conversion of Litres to mililitres ");
		System.out.println("Enter your choice ");
		int ch=sc.nextInt();
		String c;
		do {
			switch(ch)
			{
				case 1:
					System.out.println("Enter distance travelled in centimetres : ");
					double cm=sc.nextInt();
					System.out.println("The distance travelled in metres is : "+((int)cm/100)+" m");
					break;
				case 2:
					System.out.println("Enter weight in kilograms : ");
					int kg=sc.nextInt();
					System.out.println("The same weight in gram scale is : "+(kg*1000)+" g");
					break;
				case 3:
					System.out.println("Enter measuring scale of liquid in Litres : ");
					int l=sc.nextInt();
					System.out.println("The liquid in mililitre scale is : "+(l*1000)+" ml");
					break;
			}
			System.out.println("Enter Y for yes and N for no : ");
			c=sc.next();
		}while(c.equalsIgnoreCase("Y"));

	}

}
