package Skill_Programs;

import java.util.Scanner;

public class Fractions {
	
	  private int num;   // numerator
	    private int den;   // denominator

	    // Constructor
	    public Fractions(int num, int den) {
	        if (den == 0) {
	            throw new IllegalArgumentException("Denominator cannot be zero!");
	        }
	        this.num = num;
	        this.den = den;
	        simplify();
	    }

	    // Compute GCD (Euclidean Algorithm)
	    private int gcd(int a, int b) {
	        while (b != 0) {
	            int temp = a % b;
	            a = b;
	            b = temp;
	        }
	        return Math.abs(a);
	    }

	    // Reduce fraction to simplest form
	    private void simplify() {
	        int g = gcd(num, den);
	        num /= g;
	        den /= g;

	        // Handle negative denominator
	        if (den < 0) {
	            den *= -1;
	            num *= -1;
	        }
	    }

	    // Add two fractions
	    public Fractions add(Fractions f) {
	        int newNum = this.num * f.den + f.num * this.den;
	        int newDen = this.den * f.den;

	        return new Fractions(newNum, newDen); // auto-simplified
	    }

	    // Convert to string
	    public String toString() {
	        return num + "/" + den;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter numerator of first fraction: ");
	        int n1 = sc.nextInt();
	        System.out.print("Enter denominator of first fraction: ");
	        int d1 = sc.nextInt();

	        System.out.print("Enter numerator of second fraction: ");
	        int n2 = sc.nextInt();
	        System.out.print("Enter denominator of second fraction: ");
	        int d2 = sc.nextInt();

	        Fractions f1 = new Fractions(n1, d1);
	        Fractions f2 = new Fractions(n2, d2);

	        Fractions sum = f1.add(f2);

	        System.out.println("\nFirst Fraction (simplified): " + f1);
	        System.out.println("Second Fraction (simplified): " + f2);
	        System.out.println("\nSum = " + sum);

	}

}
