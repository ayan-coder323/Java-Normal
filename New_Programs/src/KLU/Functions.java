package KLU;

import java.util.Scanner;

class Stairs{
	void StairCalc(int n)
	{
		int a[]=new int[n];
		if (n==0)
		{
			System.out.println("To climb 0 stairs you will need 0 ways its obvious brother");
		}
		if (n==1)
		{
			System.out.println("To climb 1 stair you can climb it only by 1 way");
		}
		if (n==2)
		{
			System.out.println("To climb 2 stairs you can climb it in 2 ways");
		}
		if (n>3)
		{
			a[0]=1;
			a[1]=2;
		for (int i=2;i<n;i++)
		{
			a[i]=a[i-1]+a[i-2];
		}
		}
		for (int k=0;k<n;k++)
		{
			System.out.println("To climb "+(k+1)+" stairs you can climb it in "+a[k]+" ways");
		}
		
	}
}

public class Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stairs ob=new Stairs();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many stairs you want to climb : ");
		int N=sc.nextInt();
		ob.StairCalc(N);
	}

}
