package Demo_Programs;

import java.util.Scanner;

public class Missing_Element_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=sc.nextInt();
		int a[]=new int[size];
		int sum=0;
		int k=1;
		int s=0;
		System.out.println("Enter the array elements :");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		for (int i=0;i<size;i++)
		{
			sum=sum+a[i];
		}
		while(k<=a[size-1])
		{
			s=s+k;
			k++;
		}
		System.out.println(s);
		System.out.println(sum);
		System.out.println("The missing element in the array is "+(s-sum));
		
}

}
