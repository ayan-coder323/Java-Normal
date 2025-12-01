package Home_Assignments;

abstract class Shape {
    abstract double area();  // abstract method
}

class Circl extends Shape {
    double radius;

    Circl(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

interface Calculator {
    double calculate(double a, double b);
}

class ScientificCalculator implements Calculator {
    public double calculate(double a, double b) {
        return Math.pow(a, b);  // a^b
    }
}

class FinancialCalculator implements Calculator {
    public double calculate(double principal, double rate) {
        // Simple Interest = (P × R × T)
        double time = 1; // assuming 1 year for demo
        return (principal * rate * time) / 100;
    }
}
public class Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Shape s;

        s = new Circl(5); // parent ref → child object
        System.out.println("Circle Area = " + s.area());

        s = new Triangle(10, 6); // parent ref → child object
        System.out.println("Triangle Area = " + s.area());

        // Interface Polymorphism
        Calculator c;

        c = new ScientificCalculator();
        System.out.println("Scientific Calc (2^3) = " + c.calculate(2, 3));

        c = new FinancialCalculator();
        System.out.println("Financial Calc (SI on 10000 @ 10%) = " + c.calculate(10000, 10));

	}

}
