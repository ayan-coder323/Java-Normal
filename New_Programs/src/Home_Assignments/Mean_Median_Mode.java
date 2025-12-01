package Home_Assignments;

import java.util.Arrays;

public class Mean_Median_Mode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        int[] arr = {4, 2, 8, 6, 4, 8, 4};

		        // 1. MEAN
		        double sum = 0;
		        for (int x : arr) sum += x;
		        double mean = sum / arr.length;

		        // 2. MEDIAN
		        Arrays.sort(arr);
		        double median;
		        if (arr.length % 2 == 1) {
		            median = arr[arr.length / 2];
		        } else {
		            int mid1 = arr[(arr.length / 2) - 1];
		            int mid2 = arr[arr.length / 2];
		            median = (mid1 + mid2) / 2.0;
		        }

		        // 3. MODE
		        int mode = arr[0];
		        int maxCount = 1;

		        for (int i = 0; i < arr.length; i++) {
		            int count = 1;
		            for (int j = i + 1; j < arr.length; j++) {
		                if (arr[j] == arr[i]) count++;
		            }
		            if (count > maxCount) {
		                maxCount = count;
		                mode = arr[i];
		            }
		        }

		        // If no number repeats, no mode
		        if (maxCount == 1) {
		            System.out.println("No mode (all values occur only once)");
		        } else {
		            System.out.println("Mode = " + mode + " (occurs " + maxCount + " times)");
		        }

		        System.out.println("Mean = " + mean);
		        System.out.println("Median = " + median);
		    }



}
