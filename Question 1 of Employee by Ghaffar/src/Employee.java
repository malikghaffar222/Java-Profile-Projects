
public class Employee {
	private int id;
	private String name;
	private char gender;
	private double basicSalary;

	public Employee() {
		id = 0;
		name = "none";
		gender = 'N';
		basicSalary = 0.0;
	}

	public Employee(int id, String name, char gender, double basicSalary) {
		this();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.basicSalary = basicSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getSalary() {
		return basicSalary;
	}

	@Override
	public String toString() {
		return "Employee Id: " + id + "\nName: " + name + "\nGender: " + gender + "\nSalary: " + basicSalary;
	}
}
