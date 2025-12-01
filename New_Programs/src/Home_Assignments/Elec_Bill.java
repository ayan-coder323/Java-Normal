package Home_Assignments;

import java.util.Scanner;

public class Elec_Bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner sc = new Scanner(System.in);
		        
		        System.out.print("Enter the number of units consumed: ");
		        double units = sc.nextDouble();
		        
		        double bill = 0;
		        double fixedCharge = 50;
		        
		        if (units <= 100) {
		            bill = units * 1.50;
		        } 
		        else if (units <= 200) {
		            bill = (100 * 1.50) + (units - 100) * 2.50;
		        } 
		        else if (units <= 300) {
		            bill = (100 * 1.50) + (100 * 2.50) + (units - 200) * 4.00;
		        } 
		        else {
		            bill = (100 * 1.50) + (100 * 2.50) + (100 * 4.00) + (units - 300) * 5.00;
		        }
		        
		        double totalBill = bill + fixedCharge;
		        
		        System.out.println("\n--- Electricity Bill ---");
		        System.out.println("Units Consumed: " + units);
		        System.out.println("Energy Charges: ₹" + bill);
		        System.out.println("Fixed Charges: ₹" + fixedCharge);
		        System.out.println("----------------------------");
		        System.out.println("Total Bill Amount: ₹" + totalBill);
		        
		        sc.close();
	}

}
