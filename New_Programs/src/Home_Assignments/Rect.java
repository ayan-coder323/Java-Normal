package Home_Assignments;

class Rectangle1 {
    private double length;
    private double width;

    // Constructor
    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    public double calculateArea() {
        return length * width;
    }

    // Method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Display details
    public void display() {
        System.out.println("Length       : " + length);
        System.out.println("Width        : " + width);
        System.out.println("Area         : " + calculateArea());
        System.out.println("Perimeter    : " + calculatePerimeter());
    }
}

public class Rect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Rectangle1 r = new Rectangle1(10, 5); // Example values

        r.display();
	}

}
