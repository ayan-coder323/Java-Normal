package Skill_Programs;

import java.util.Scanner;

public class Set_bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {   // Check last bit
                count++;
            }
            n = n >> 1;           // Shift right
        }

        System.out.println("Number of set bits = " + count);
	}

}
