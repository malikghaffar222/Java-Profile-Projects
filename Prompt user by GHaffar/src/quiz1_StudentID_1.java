import java.util.Scanner;

public class quiz1_StudentID_1 {
	public static void main(String[] args) {
		int n1, n2;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1st num: ");
		n1 = input.nextInt();
		System.out.print("Enter 2nd num: ");
		n2 = input.nextInt();

		if (n1 > 0 && n2 > 0) {
			System.out.println("0. Exit");
			System.out.println("1. Sum");
			System.out.println("2. Sum and Average");
			System.out.println("3. Sum, average and max ");
			System.out.println("Choose your option[0,1,2,3]:");
			int choice = input.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Exit successful");
				System.exit(0);
				break;

			case 1:
				System.out.println("Sum: " + n1 + "+" + n2 + " = " + (n1 + n2));

				break;

			case 2:
				System.out.println("Sum: " + n1 + "+" + n2 + " = " + (n1 + n2));
				double average = (double) ((n1 + n2) / 2);
				System.out.println("Average: " + n1 + " and " + n2 + " = " + average);
				break;
			case 3:
				System.out.println("Sum: " + n1 + "+" + n2 + " = " + (n1 + n2));
				average = (n1 + n2) / 2;
				System.out.println("Average: " + n1 + " and " + n2 + " = " + average);
				System.out.println("Average: " + n1 + " and " + n2 + " = " + Math.max(n2, n2));
				break;

			default:
				break;
			}
		}
	}
}
