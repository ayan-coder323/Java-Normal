package Demo_Programs;

import java.util.Scanner;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder s=new StringBuilder();
		System.out.println("Enter a string :");
		String str=sc.nextLine();
		boolean appeared[]=new boolean[256];
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if (!appeared[c])
			{
				s.append(c);
				appeared[c]=true;
			}
			
		}
		System.out.println("The string after removing the duplicate characters is "+s);
	}

}
