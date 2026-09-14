import java.util.Scanner;
class Employee {
	protected int id;
	protected String name;
	protected double Salary;
	protected String Type;
	public Employee(int id, String name, double Salary) {this.id = id;this.name= name ;this.Salary = Salary;}
	public double CalculateSalary() {return Salary;}
	public String Type() {return Type;}
	public void display() {System.out.print(id+ " " + name + " " + CalculateSalary()+ " " + Type());}
}
class Permanent extends Employee {
	public Permanent(int id, String name, double Salary) {super(id,name,Salary);}
	@Override public double CalculateSalary() {return Salary + (0.2 * Salary) + (0.1 * Salary);}
	@Override public String Type() {return "Permanent";}
}
class Contract extends Employee {
	public Contract(int id, String name, double Salary) {super(id,name,Salary);}
	@Override public double CalculateSalary() {return  Salary + 5000 + 0;}
	@Override public String Type() {return "Contract";}
}
class Intern extends Employee {
	public Intern(int id, String name, double Salary) {super(id,name,Salary);}
	@Override public double CalculateSalary() {return 15000;}
	@Override public String Type() {return "Intern";}
}
public class Payroll {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		Employee[] emp = new Employee[2];
		for(int i=0; i<1; i++) {
			System.out.println("Enter Employee Number: ");
			int id = obj.nextInt();
			obj.nextLine();
			System.out.println("Enter Employee Name: ");
			String name = obj.nextLine();
			System.out.println("Enter Employee Type{1-P/2-C/3-I} : ");
			int Type = obj.nextInt();
			System.out.println("Enter Basic Salary: ");
			double Salary = obj.nextDouble();
			switch(Type) {
			case 1 : emp[i] = new Permanent(id,name,Salary); break;
			case 2 : emp[i] = new Contract(id,name,Salary);break;
			case 3 : emp[i] = new Intern(id,name,Salary); break;
			default: System.exit(0);
			}
		}
		Employee maxEmp = emp[0];
		for(Employee e : emp) {e.display();}
		if (e.CalculateSalary() > maxEmp.CalculateSalary()) {maxEmp = e;}
		System.out.println("Maximum Salay: " + maxEmp.CalculateSalary();)

	}
}
