package Skill_Programs;

import java.util.Scanner;

public class Determinant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int[][] m = new int[3][3];

        System.out.println("Enter elements of 3×3 matrix:");

        // Taking input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        // Assigning variables for formula
        int a = m[0][0], b = m[0][1], c = m[0][2];
        int d = m[1][0], e = m[1][1], f = m[1][2];
        int g = m[2][0], h = m[2][1], i = m[2][2];

        // Determinant formula
        int determinant =
                  a * (e * i - f * h)
                - b * (d * i - f * g)
                + c * (d * h - e * g);

        System.out.println("\nDeterminant = " + determinant);

	}

}
