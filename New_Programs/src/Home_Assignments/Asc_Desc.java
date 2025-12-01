package Home_Assignments;

public class Asc_Desc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        int[] arr = {1, 2, 3, 4, 5};

		        boolean asc = true;
		        boolean desc = true;

		        for (int i = 0; i < arr.length - 1; i++) {
		            if (arr[i] > arr[i + 1]) {
		                asc = false;
		            }
		            if (arr[i] < arr[i + 1]) {
		                desc = false;
		            }
		        }

		        if (asc)
		            System.out.println("Array is sorted in ASCENDING order");
		        else if (desc)
		            System.out.println("Array is sorted in DESCENDING order");
		        else
		            System.out.println("Array is NOT sorted");
		    }

}

