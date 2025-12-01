package Skill_Programs;

public class XOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {4, 1, 2, 1, 2};

        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];   // XOR with each element
        }

        System.out.println("Single non-repeating element: " + xor);
	}

}
