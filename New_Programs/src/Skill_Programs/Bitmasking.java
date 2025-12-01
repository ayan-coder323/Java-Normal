package Skill_Programs;

public class Bitmasking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {1, 2, 3};
        int n = arr.length;

        int total = 1 << n;  // 2^n

        System.out.println("All Subsets:");

        // Loop over all bitmasks
        for (int mask = 0; mask < total; mask++) {

            System.out.print("{ ");

            // Check each bit
            for (int i = 0; i < n; i++) {

                // If i-th bit is set, include arr[i]
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println("}");
        }

	}

}
