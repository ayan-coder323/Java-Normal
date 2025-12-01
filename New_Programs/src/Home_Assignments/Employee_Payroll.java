package Home_Assignments;

class Employee {
    private int empId;
    private String name;
    private double salary;  // Basic salary

    // Constructor
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate net salary
    // (Assume: 10% PF deduction, 5% professional tax)
    public double calculateNetSalary() {
        double pf = salary * 0.10;
        double tax = salary * 0.05;
        return salary - (pf + tax);
    }

    // Display details
    public void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name       : " + name);
        System.out.println("Basic Pay  : " + salary);
        System.out.println("Net Salary : " + calculateNetSalary());
    }
}
public class Employee_Payroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Employee e1 = new Employee(101, "Ayan Roy", 50000);

        e1.displayEmployee(); 

	}

}
