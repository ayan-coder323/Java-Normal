package Skill_Programs;

import java.util.Scanner;

public class Tower_of_Hanoi {
    static void solve(int n, char src, char helper, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }

        // Step 1: Move n-1 disks from src to helper
        solve(n - 1, src, dest, helper);

        // Step 2: Move the nth disk to destination
        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        // Step 3: Move n-1 disks from helper to destination
        solve(n - 1, helper, src, dest);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        System.out.println("\nSteps to solve Tower of Hanoi:");
        solve(n, 'A', 'B', 'C');

	}

}
