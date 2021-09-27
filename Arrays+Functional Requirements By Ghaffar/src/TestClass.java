import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws IOException {
		Course course = new Course("Science", "Ali");

		Scanner scanner = new Scanner(new File("StudentDetails.txt"));
		while (scanner.hasNextLine()) {
			String name = scanner.nextLine().split("[:]+")[1].trim();
			String dob = scanner.nextLine().split("[: ]+")[1].trim();
			String address = scanner.nextLine().split("[: ]+")[1].trim();
			String gender = scanner.nextLine().split("[: ]+")[1].trim();
			if (!course.addStudent(new Student(name, dob, address, gender)))
				break;
			scanner.nextLine();
		}
		scanner.close();
//the data which i added to the files on first attempt 
//		Student[] students = new Student[19];
//		students[0] = new Student("A", "02/10/2002", "UK", "M");
//		students[1] = new Student("B", "12/10/2001", "PK", "F");
//		students[2] = new Student("C", "22/11/2003", "USA", "M");
//		students[3] = new Student("D", "02/09/2002", "IND", "M");
//		students[4] = new Student("E", "01/10/2001", "UAE", "M");
//		students[5] = new Student("U", "03/08/2002", "ITL", "F");
//		students[6] = new Student("G", "04/10/2001", "PT", "F");
//		students[7] = new Student("H", "02/09/2004", "SA", "M");
//		students[8] = new Student("I", "03/10/2001", "AUS", "F");
//		students[9] = new Student("J", "05/07/2000", "ENG", "M");
//		students[10] = new Student("K", "02/05/2002", "NEW", "M");
//		students[11] = new Student("L", "14/02/2000", "WES", "M");
//		students[12] = new Student("N", "23/11/2001", "POR", "F");
//		students[13] = new Student("O", "29/03/2003", "GER", "M");
//		students[14] = new Student("P", "09/08/2001", "RUSS", "M");
//		students[15] = new Student("Q", "10/10/2002", "PALES", "F");
//		students[16] = new Student("R", "11/05/2005", "SINGA", "F");
//		students[17] = new Student("S", "03/10/2003", "NEP", "M");
//		students[18] = new Student("T", "10/04/2003", "BAN", "F");
//

		int choice = 0;
		scanner = new Scanner(System.in);
		while (choice != 5) {
			System.out.println("1. Add Student to Course");
			System.out.println("2. Delete Student from Course");
			System.out.println("3. Search a Student from Course");
			System.out.println("4. Print details of Course");
			System.out.println("5. Exit");
			System.out.println("Enter our choice: ");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				String name = scanner.next();
				scanner.nextLine(); // for line span
				System.out.print("Enter date of birth(dd/mm/yyyy): ");
				String dob = scanner.next();
				scanner.nextLine(); // for line span
				System.out.print("Enter address: ");
				String address = scanner.nextLine();
				System.out.print("Enter gender(M/F): ");
				String gender = scanner.next();
				if (!gender.equals("M") && !gender.equals("F")) {
					System.out.println("Invalid gender input...");
					continue;
				}
				course.addStudent(new Student(name, dob, address, gender));
				System.out.println();
				break;
			case 2:
				System.out.print("Enter name: ");
				name = scanner.next();
				course.deleteStudent(name);
				System.out.println();
				break;
			case 3:
				System.out.print("Enter name: ");
				name = scanner.next();
				course.search(name);
				System.out.println();
				break;
			case 4:
				System.out.println(course.courseDetails());
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice! ... Try again!");
				break;
			}
		}

		FileWriter file1 = new FileWriter(new File("StudentDetails.txt"));
		FileWriter file2 = new FileWriter(new File("CourseDetails.txt"));
		file1.flush();
		file2.flush();
		for (int i = 0; i < course.size(); i++) {
			Student student = course.getStudent(i);
			file1.write(student.toString() + "\n\n");
		}
		file1.close();
		file2.write(course.toString());
		file2.close();
	}

}
