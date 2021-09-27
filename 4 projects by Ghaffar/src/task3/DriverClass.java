package task3;

public class DriverClass {

	public static void main(String[] args) {
		java.util.Scanner kbd = new java.util.Scanner(System.in);
		LinkedListOfEmployees employees = new LinkedListOfEmployees();
		int option = -1;
		while (option != 0) {
			System.out.println("To add a new employee, Enter 1");
			System.out.println("To get the number of employees of a given gender, Enter 2");
			System.out.println("To get and display the oldest employee, Enter 3");
			System.out.println("To get and display all employees of a given gender, enter 4");
			System.out.println("To view all Male employees in the Linked List, Enter 5");
			System.out.println("To Exit, Enter 0");
			System.out.print("Enter Your Option: ");
			option = kbd.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter employee id: ");
				int employeeId = kbd.nextInt();
				kbd.nextLine();// for line span
				System.out.println("Enter name: ");
				String name = kbd.nextLine();
				System.out.println("Enter gender(male/female): ");
				String gender = kbd.next();
				System.out.println("Enter age: ");
				int age = kbd.nextInt();

				employees.insertAtFront(new Employee(employeeId, name, gender, age));
				System.out.println("\n" + name + " employee added.\n");
				break;
			case 2:
				System.out.println("Enter gender(male/female): ");
				gender = kbd.next();
				System.out.println("\nTotal number of employees with gender(" + gender + ") is "
						+ employees.countEmployees(gender) + "\n");
				break;
			case 3:
				employees.getOldestEmployee().displayEmployeeInfo();
				System.out.println();
				break;
			case 4:
				System.out.println("Enter gender(male/female): ");
				gender = kbd.next();
				employees.getEmployees(gender).display();
				System.out.println();
				break;
			case 5:
				employees.getEmployees("male").display();
				System.out.println();
				break;
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option!");
				System.out.println();
				break;
			}
		}

	}

}
