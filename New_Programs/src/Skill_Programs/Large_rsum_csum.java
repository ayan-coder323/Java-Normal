package Skill_Programs;

public class Large_rsum_csum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int maxRowSum = Integer.MIN_VALUE;
        int rowIndex = -1;

        // Find Largest Row Sum
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (sum > maxRowSum) {
                maxRowSum = sum;
                rowIndex = i;
            }
        }

        int maxColSum = Integer.MIN_VALUE;
        int colIndex = -1;

        // Find Largest Column Sum
        for (int j = 0; j < arr[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][j];
            }
            if (sum > maxColSum) {
                maxColSum = sum;
                colIndex = j;
            }
        }

        System.out.println("Row with largest sum: Row " + rowIndex + " = " + maxRowSum);
        System.out.println("Column with largest sum: Column " + colIndex + " = " + maxColSum);

	}

}
