package Skill_Programs;

public class Magic_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[][] arr = { 
		            {2, 7, 6}, 
		            {9, 5, 1}, 
		            {4, 3, 8} 
		        };

		        int n = arr.length;

		        // Step 1: Calculate the reference sum (first row)
		        int magicSum = 0;
		        for (int j = 0; j < n; j++) {
		            magicSum += arr[0][j];
		        }

		        // Step 2: Check all row sums
		        for (int i = 0; i < n; i++) {
		            int rowSum = 0;
		            for (int j = 0; j < n; j++) {
		                rowSum += arr[i][j];
		            }
		            if (rowSum != magicSum) {
		                System.out.println("Not a Magic Square");
		                return;
		            }
		        }

		        // Step 3: Check all column sums
		        for (int j = 0; j < n; j++) {
		            int colSum = 0;
		            for (int i = 0; i < n; i++) {
		                colSum += arr[i][j];
		            }
		            if (colSum != magicSum) {
		                System.out.println("Not a Magic Square");
		                return;
		            }
		        }

		        // Step 4: Check diagonals
		        int d1 = 0, d2 = 0;
		        for (int i = 0; i < n; i++) {
		            d1 += arr[i][i];           // main diagonal
		            d2 += arr[i][n - 1 - i];   // secondary diagonal
		        }

		        if (d1 != magicSum || d2 != magicSum) {
		            System.out.println("Not a Magic Square");
		            return;
		        }

		        System.out.println("It IS a Magic Square!");

	}

}
