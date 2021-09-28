import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try {
			Scanner kbd = new Scanner(System.in);
			// creating files
			PrintWriter stdsInfoFile = new PrintWriter(new File("Students Information.txt"));
			PrintWriter testScoreFile = new PrintWriter(new File("Test Score File.txt"));

			double totalPossiblePoints;
			boolean isLess; // creating flag
			do {
				System.out.print("Enter total possible points for the test: ");
				totalPossiblePoints = kbd.nextDouble();
				isLess = totalPossiblePoints <= 0;
				if (isLess)
					System.out.println("\nInvalid possible points! try again...");
			} while (isLess); // repeat until possible points is negative

			// writing total possible points to file
			stdsInfoFile.printf("Total Posible Points For Exam: %.2f\n", totalPossiblePoints);
			// we want five students to be added only
			for (int i = 1; i <= 3; i++) {
				System.out.println("Student #" + i);
				System.out.print("Input first name: ");
				String fName = kbd.next();
				System.out.print("Input last name: ");
				String lName = kbd.next();
				double testScore;
				boolean isGreater;
				do {
					System.out.print("Input test score: ");
					testScore = kbd.nextDouble();
					isGreater = testScore > totalPossiblePoints; // creating flag
					if (isGreater)
						System.out.println("\nTest score should be less than total possible points! try again...");
				} while (isGreater); // repeat until test score is greater than possible points

				Student student = new Student(fName, lName, testScore); // creating students
				// calculate percentage based
				// on possible points
				double testPercentage = student.calculatePercentage(totalPossiblePoints);
				student.setTestPercentage(testPercentage);
				// calculate letter grade based on
				// test percentage points
				char letterGrade = student.calculateLetterGrade();
				// writing to files
				stdsInfoFile.printf("%5s", student.getLastName());
				stdsInfoFile.printf("%10s", student.getFirstName());
				stdsInfoFile.printf("%15.2f", student.getTestScore());
				stdsInfoFile.printf("%10.2f", student.getTestPercentage());
				stdsInfoFile.printf("%5c\n", letterGrade);
				testScoreFile.printf("%.2f\n",student.getTestScore());

				// putting a line on screen // for readability
				System.out.println();
			}
			// closing writing files
			stdsInfoFile.close();
			testScoreFile.close();

			// file reading
			kbd = new Scanner(new File("Test Score File.txt"));
			double averageScore = 0, averagePercent = 0;
			int count = 0;
			while (kbd.hasNextLine()) {
				count++; // counting total number of students' scores
				// summing up test scores of all students
				averageScore += Double.parseDouble(kbd.nextLine());
			}
			// calculating average score and percentage of exam and formatting both up to
			// two decimal places
			averageScore = averageScore / count;
			averagePercent = (averageScore / totalPossiblePoints) * 100;
			System.out.printf("Average score of the exam: %.2f\n", averageScore);
			System.out.printf("Average percentage of the exam: %.2f", averagePercent);
			System.out.println("%");
			kbd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
