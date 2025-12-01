package Skill_Programs;

import java.util.Scanner;

public class Flood_fill {
		// TODO Auto-generated method stub
	    // DFS flood-fill function
	    static void fill(int[][] grid, int r, int c, int target, int replace) {

	        int n = grid.length;
	        int m = grid[0].length;

	        // 1. Boundary check
	        if (r < 0 || r >= n || c < 0 || c >= m)
	            return;

	        // 2. Value must match the target
	        if (grid[r][c] != target)
	            return;

	        // 3. Replace the value
	        grid[r][c] = replace;

	        // 4. Spread in 4 directions
	        fill(grid, r + 1, c, target, replace); // down
	        fill(grid, r - 1, c, target, replace); // up
	        fill(grid, r, c + 1, target, replace); // right
	        fill(grid, r, c - 1, target, replace); // left
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // Input matrix
	        System.out.print("Enter number of rows: ");
	        int n = sc.nextInt();
	        System.out.print("Enter number of columns: ");
	        int m = sc.nextInt();

	        int[][] grid = new int[n][m];

	        System.out.println("\nEnter matrix:");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                grid[i][j] = sc.nextInt();
	            }
	        }

	        // Starting point & new value
	        System.out.print("\nEnter starting row: ");
	        int sr = sc.nextInt();
	        System.out.print("Enter starting column: ");
	        int scn = sc.nextInt();
	        System.out.print("Enter new value to fill: ");
	        int newVal = sc.nextInt();

	        int target = grid[sr][scn]; // original color/value

	        // If replacing with same value, no change
	        if (target != newVal) {
	            fill(grid, sr, scn, target, newVal);
	        }

	        // Output
	        System.out.println("\nMatrix after Flood-Fill:");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                System.out.print(grid[i][j] + " ");
	            }
	            System.out.println();
	        }

	}

}
