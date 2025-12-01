package Home_Assignments;

import java.util.Arrays;
import java.util.Scanner;


public class Second_Large_Small {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=sc.nextInt();
		int a[]=new int[size];
		System.out.println("Enter the array elements :");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		System.out.println("The second largest element present in the array is :"+a[size-2]);
		System.out.println("The second smallest element present in the array is: "+a[1]);
	}

}
