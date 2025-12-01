package Demo_Programs;

import java.util.Scanner;

public class Camelcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string :");
		StringBuffer s=new StringBuffer(sc.nextLine());
		boolean capitalize=false;
		StringBuffer result=new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if (c==' ')
			{
				c=s.charAt(i);
				capitalize=true;
			}
			else
			{
				if (capitalize)
				{
					result.append(Character.toUpperCase(c));
					capitalize=false;
				}
				else
				{
					if (i==0)
					{
						result.append(Character.toUpperCase(c));
					}
					else
					{
						result.append(Character.toLowerCase(c));
					}
				}
			}
		}
		System.out.println("String in Camel Case : "+result);

	}
}
