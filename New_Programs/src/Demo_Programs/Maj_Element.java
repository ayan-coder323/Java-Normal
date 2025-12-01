package Demo_Programs;

import java.util.Scanner;

public class Maj_Element {

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
			if (c>(size/2))
			{
				System.out.println(a[i]+" has appeared more than "+(float)size/2+" times so the majority element is "+a[i]);
			}

	}

}
}
