package Skill_Programs;

import java.util.Scanner;

public class Quad_eq_class {
	 private double a, b, c;

	    // Constructor
	    public Quad_eq_class(double a, double b, double c) {
	        this.a = a;
	        this.b = b;
	        this.c = c;
	    }

	    // Compute discriminant: b² - 4ac
	    public double getDiscriminant() {
	        return (b * b) - (4 * a * c);
	    }

	    // Compute roots based on discriminant
	    public void computeRoots() {

	        double D = getDiscriminant();

	        System.out.println("Discriminant = " + D);

	        if (D > 0) {
	            // Two distinct real roots
	            double r1 = (-b + Math.sqrt(D)) / (2 * a);
	            double r2 = (-b - Math.sqrt(D)) / (2 * a);
	            System.out.println("Two real roots:");
	            System.out.println("Root 1 = " + r1);
	            System.out.println("Root 2 = " + r2);

	        } else if (D == 0) {
	            // One real root
	            double r = -b / (2 * a);
	            System.out.println("One real root:");
	            System.out.println("Root = " + r);

	        } else {
	            // Complex roots
	            double real = -b / (2 * a);
	            double imag = Math.sqrt(-D) / (2 * a);
	            System.out.println("Complex roots:");
	            System.out.println("Root 1 = " + real + " + " + imag + "i");
	            System.out.println("Root 2 = " + real + " - " + imag + "i");
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a: ");
	        double a = sc.nextDouble();
	        System.out.print("Enter b: ");
	        double b = sc.nextDouble();
	        System.out.print("Enter c: ");
	        double c = sc.nextDouble();

	        Quad_eq_class q = new Quad_eq_class(a, b, c);

	        q.computeRoots();

	}
}
