package KLU;

import java.util.Scanner;

public class Hard_Program {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the charge on which your device is working ath the moment :");
		int charge=sc.nextInt();
		int time=0;
		if (charge==50)
		{
			System.out.println("Total time needed for charge to turn 50 percent is "+time+" mins");
		}
		if (charge>50) {
		while(true)
		{
			charge=charge-3;
			time++;
			if (charge<50)
			{
				break;
			}
		}
		while(true)
		{
			if (charge!=50)
			{
				if (charge%2==0)
				{
					charge=charge+2;
					time++;
				}
				else
				{
					charge=charge-3;
					time++;
				}
				if (charge==50)
				{
					System.out.println("Total time needed for charge to turn 50 percent is "+time+" mins");
					break;
				}
			}
			
		}
	}
		else
		{
			if ((charge%2)!=0)
			{
				while(true)
				{
					charge=charge+2;
					time++;
					if (charge>50)
					{
						if(charge%2!=0)
						{
							charge=charge-3;
							time++;
						}
						if(charge%2==0)
						{
							charge=charge+2;
							time++;
						}
						if(charge==50)
						{
							System.out.println("Total time needed for charge to turn 50 percent is "+time+" mins");
							break;
						}
					}
				}
			}
			else
			{
				while(true)
				{
					charge=charge+2;
					time++;
					if (charge==50)
					{
						System.out.println("Total time needed for charge to turn 50 percent is "+time+" mins");
						break;
					}
				}
				
			}
				
		}
	}
}
