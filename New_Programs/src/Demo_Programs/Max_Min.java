package Demo_Programs;

import java.util.Scanner;

public class Max_Min {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array :");
        int size = sc.nextInt();
        int a[] = new int[size];
        
        System.out.println("Enter the array elements :");
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        
        int max = a[0];
        int min = a[0];
        
        for (int i = 1; i < size; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        
        System.out.println("The maximum element present in the array is " + max);
        System.out.println("The minimum element present in the array is " + min);
    }
}
