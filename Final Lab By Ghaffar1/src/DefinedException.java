import java.util.Scanner;

public class DefinedException {
	public static void main(String[] args) {
		String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		try {
			Scanner keyboard = new Scanner(System.in);
			int day = keyboard.nextInt();
			System.out.println(days[day]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
