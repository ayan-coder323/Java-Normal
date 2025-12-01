package Home_Assignments;

import java.util.Scanner;

public class Speed_Time_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String c;
		do {
		System.out.println("Press\n1. If you want to give Speed and Distance values\n2. If you want to give Distance and Time values and\n3. If you want to give only Speed and Time values");
		int ch=sc.nextInt();
		if (ch==1)
		{
			System.out.println("Enter the Speed in metre per seconds and Distance in metres :");
			int speed=sc.nextInt();
			int dist=sc.nextInt();
			System.out.println("The time taken to travel "+dist+" metres at "+speed+" m/s is "+dist/speed+" seconds");
		}
		else if (ch==2)
		{
			System.out.println("Enter the Distance in metres and Time in seconds :");
			int dist=sc.nextInt();
			int time=sc.nextInt();
			System.out.println("The speed required to travel"+dist+" metres in "+time+" seconds is "+dist/time+" m/s");
		}
		else if(ch==3)
		{
			System.out.println("Enter the Speed in metre per seconds and time in seconds :");
			int speed=sc.nextInt();
			int time=sc.nextInt();
			System.out.println("The distance travelled in "+time+" seconds at "+speed+" m/s is "+speed*time+" metres");
		}
		else
		{
			System.out.println("Invalid Choice Bro Try Again.......");
		}
		System.out.println("Enter Y for printing anything other than the thing you chose right now and N to exit");
		c=sc.next();
		} while (c.equalsIgnoreCase("Y"));
	}

}
