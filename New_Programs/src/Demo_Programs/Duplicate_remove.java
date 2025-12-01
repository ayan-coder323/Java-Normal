package Demo_Programs;

import java.util.Scanner;

public class Duplicate_remove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=sc.nextInt();
		int a[]=new int[size];
		int j=0;
		System.out.println("Enter the array elements :");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		for(int i=1;i<size;i++)
		{
			if(a[i]!=a[j])
			{
				j++;
				int t=0;
				t=a[j];
				a[j]=a[i];
				a[i]=t;
			}
		}
		System.out.println("Array after manipulation :");
		for(int i=0;i<=j;i++)
		{
			System.out.println(a[i]);
		}

	}

}
