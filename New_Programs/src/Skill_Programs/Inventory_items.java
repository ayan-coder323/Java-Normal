package Skill_Programs;

import java.util.Scanner;

public class Inventory_items {
	
	 private String name;
	    private double price;
	    private int quantity;

	    // Constructor
	    public Inventory_items(String name, double price, int quantity) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    // Setters
	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    // Compute total inventory value for this item
	    public double getTotalValue() {
	        return price * quantity;
	    }

	    // Display item details
	    public void display() {
	        System.out.println("Item: " + name);
	        System.out.println("Price: ₹" + price);
	        System.out.println("Quantity: " + quantity);
	        System.out.println("Total Value: ₹" + getTotalValue());
	        System.out.println("--------------------------");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Inventory_items item = new Inventory_items(name, price, qty);

        System.out.println("\nInventory Item Details:");
        item.display();

	}

}
