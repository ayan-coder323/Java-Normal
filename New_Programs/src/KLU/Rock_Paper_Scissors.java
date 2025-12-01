package KLU;

import java.util.*;

public class Rock_Paper_Scissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("How many rounds do you want to play : ");
		int rounds=sc.nextInt();
		int c=0,y=0,i=0;
		do {
		System.out.println("1.Press 1 for Rock \n2.Press 2 for Paper \n3.Press 3 for Scissor");
		int ch=sc.nextInt();
		int r=(int)(Math.random()*3)+1;
		System.out.println(r);
		switch(ch)
		{
		case 1:
			if (r==1)
			{
				System.out.println("Draw");
			}
			else if(r==2)
			{
				System.out.println("Comp won");
				c++;
			}
			else
			{
				System.out.println("You won");
				y++;
			}
			break;
		case 2:
			if (r==2)
			{
				System.out.println("Draw");
			}
			else if(r==1)
			{
				System.out.println("You won");
				y++;
			}
			else
			{
				System.out.println("Comp won");
				c++;
			}
			break;
		case 3:
			if (r==3)
			{
				System.out.println("Draw");
			}
			else if(r==2)
			{
				System.out.println("You won");
				y++;
			}
			else
			{
				System.out.println("Comp won");
				c++;
			}
			break;
		}
		i++;
		}while(i<rounds);
		System.out.println("The Computer has won "+c+" times");
		System.out.println("You have won "+y+"  times");
		if (c==y)
		{
			System.out.println("Both ended up in a draw");
		}
		else if(c>y)
		{
			System.out.println("Final winner is Computer Sharam karle bhai bot se har gaya");
		}
		else
		{
			System.out.println("You are the Final Winner");
		}
	}
}
