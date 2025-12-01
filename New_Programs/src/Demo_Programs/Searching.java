package Demo_Programs;
import java.util.Arrays;
import java.util.Scanner;

public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Press\n1 for Linear Search :\n2 for Binary Search :");
		int ch=sc.nextInt();
		int element=0;
		if (ch==1)
		{
			System.out.println("Enter the size of the array :");
			int size=sc.nextInt();
			int a[]=new int[size];
			System.out.println("Enter the array elements :");
			for(int i=0;i<size;i++)
			{
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			System.out.println("Enter the element you want to search :");
			element=sc.nextInt();
			for(int i=0;i<size;i++)
			{
				if(a[i]==element)
				{
					System.out.println("Element found");
				}
				else
				{
					continue;
				}
			}
		}
		else
		{
			System.out.println("Enter the size of the array :");
			int size=sc.nextInt();
			int a[]=new int[size];
			System.out.println("Enter the array elements :");
			for(int i=0;i<size;i++)
			{
				a[i]=sc.nextInt();
			}
			Arrays.sort(a);
			System.out.println("Enter the element you want to search :");
			element=sc.nextInt();
			int low=0,mid=0;
			for (int i=0;i<size;i++)
			{
				mid=(low+size)/2;
				if (element==a[mid])
				{
					System.out.println("Element found");
				}
				else if(element<a[mid])
				{
					size=mid;
					if (element==a[i])
					{
						System.out.println("Element found");
					}
					else
					{
						continue;
					}
				}
				else
				{
					i=mid+1;
					if (element==a[i])
					{
						System.out.println("Element found ");
					}
					else
					{
						continue;
					}
				}
			}
		}
			
	}
}
