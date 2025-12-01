package Skill_Programs;

import java.util.Scanner;

public class Array_Rearrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=scanner.nextInt();
		int a[]=new int[size];
		System.out.println("Enter the elements of the array :");
		for (int i=0;i<size;i++)
		{
			a[i]=scanner.nextInt();
		}
		int left=0,right=size-1,t=0;
		while(left<right)
		{
			t=0;
			t=a[left];
			a[left]=a[right];
			a[right]=t;
			left++;
			right--;
		}
		System.out.println("Array after reversal is : ");
		for (int i=0;i<size;i++)
		{
			System.out.println(a[i]);
		}
	}

}
