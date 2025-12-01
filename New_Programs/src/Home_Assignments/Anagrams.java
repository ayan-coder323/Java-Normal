package Home_Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two strings :");
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		s1=s1.replaceAll("\\s", "").toLowerCase();
		s2=s2.replaceAll("\\s","").toLowerCase();
		char c1[]=new char[s1.length()];
		char c2[]=new char[s2.length()];
		c1=s1.toCharArray();
		c2=s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1,c2))
		{
			System.out.println("Given strings are anagrams ");
		}
		else
		{
			System.out.println("Given strings are not anagrams ");
		}
		sc.close();
	}

}
