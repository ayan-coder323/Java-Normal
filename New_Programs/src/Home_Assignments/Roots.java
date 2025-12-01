package Home_Assignments;

import java.util.Scanner;

public class Roots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		        System.out.println("Enter coefficients of quadratic equation (a, b, c):");
		        double a = sc.nextDouble();
		        double b = sc.nextDouble();
		        double c = sc.nextDouble();

		        
		        if (a == 0) {
		            System.out.println("This is not a quadratic equation (a cannot be 0).");
		            return;
		        }

		        double discriminant = b * b - 4 * a * c;
		        System.out.println("\nDiscriminant (b² - 4ac) = " + discriminant);

		        
		        if (discriminant > 0) {
		            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		            System.out.println("Roots are real and distinct:");
		            System.out.println("Root 1 = " + root1);
		            System.out.println("Root 2 = " + root2);
		        } 
		        else if (discriminant == 0) {
		        
		            double root = -b / (2 * a);
		            System.out.println("Roots are real and equal:");
		            System.out.println("Root 1 = Root 2 = " + root);
		        } 
		        else {
		        
		            double realPart = -b / (2 * a);
		            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
		            System.out.println("Roots are imaginary (complex):");
		            System.out.printf("Root 1 = %.2f + %.2fi\n", realPart, imaginaryPart);
		            System.out.printf("Root 2 = %.2f - %.2fi\n", realPart, imaginaryPart);
		        }

		        sc.close();
	}

}
