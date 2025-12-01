package Home_Assignments;

class Circle1 {
    private double radius;

    // Constructor
    public Circle1(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Display details
    public void display() {
        System.out.println("Radius            : " + radius);
        System.out.println("Area              : " + calculateArea());
        System.out.println("Circumference     : " + calculateCircumference());
    }
}

public class CIrcle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Circle1 c = new Circle1(5.0); // Example radius
        
        c.display();

	}

}
