package Demo_Programs;

import java.util.Scanner;

public class Freq_calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array :");
		int size=sc.nextInt();
		int a[]=new int[size];
		int c=0;
		System.out.println("Enter the array elements :");
		for(int i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
		boolean calculated[]=new boolean[size];
		for (int i=0;i<size;i++)
		{
			if (calculated[i]) {
				continue;
			}
			c=1;
			for(int j=i+1;j<size;j++)
			{
				
				if (a[i]==a[j])
				{
					c++;
					calculated[j]=true;
				}
			}
			System.out.println("The frequency of the element "+a[i]+" is "+c);
		}

	}

}
