package Skill_Programs;

import java.util.Scanner;

public class Power_of_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Condition: n should be > 0 and n & (n-1) == 0
        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println(n + " is a Power of 2");
        } else {
            System.out.println(n + " is NOT a Power of 2");
        }

	}

}
