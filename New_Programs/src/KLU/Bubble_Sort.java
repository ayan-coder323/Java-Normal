package KLU;

import java.util.Scanner;

public class Bubble_Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();

        int a[] = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }

        // Bubble Sort logic
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Display
        System.out.println("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.println(a[i]);
        }
    }
}
