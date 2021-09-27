package task3;

public class Employee {
	private int employeeId;
	private String name;
	private String gender;
	private int age;

	public Employee(int employeeId, String name, String nat, int age) {
		this.employeeId = employeeId;
		this.name = name;
		this.gender = nat;
		this.age = age;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void displayEmployeeInfo() {
		System.out.println("\nEmployee ID: " + employeeId + "\nName: " + name + "\nGender: " + gender + "\nAge: " + age);
	}

}
