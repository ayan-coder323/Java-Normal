package Skill_Programs;

import java.util.Scanner;

public class Student_Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of students :");
		int sno=sc.nextInt();
		sc.nextLine();
		String name[]=new String[sno];
		int avg[]=new int[sno];
		for(int i=0;i<sno;i++)
		{
			System.out.println("Enter the student name : ");
			name[i]=sc.nextLine();
			System.out.println("Enter the number of subjects : ");
			int sub=sc.nextInt();
			sc.nextLine();
			int total=0;
			System.out.println("Enter the marks of "+sub+" subjects");
			for(int j=0;j<sub;j++)
			{
				total=total+sc.nextInt();
			}
			sc.nextLine();
			avg[i]=total/sub;
		}
		
	       for (int i = 0; i < sno - 1; i++) {
	            for (int j = 0; j < sno - i - 1; j++) {
	                if (avg[j] < avg[j + 1]) {
	                    // swap averages
	                    int tempAvg = avg[j];
	                    avg[j] = avg[j + 1];
	                    avg[j + 1] = tempAvg;

	                    // swap names
	                    String tempName = name[j];
	                    name[j] = name[j + 1];
	                    name[j + 1] = tempName;
	                }
	            }
	        }
	       for (int i=0;i<sno;i++)
	       {
	    	   		System.out.println(avg[i]);
	       }
	       System.out.println("Top 3 students are : ");
	       System.out.println(name[0]+" with an average of "+avg[0]);
	       System.out.println(name[1]+" with an average of "+avg[1]);
	       System.out.println(name[2]+" with an average of "+avg[2]);
	}

}
