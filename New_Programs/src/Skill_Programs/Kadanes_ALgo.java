package Skill_Programs;

public class Kadanes_ALgo {
    public static int maxSubArray(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // Output: 6
    }

}
