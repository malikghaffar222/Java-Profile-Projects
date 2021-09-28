import java.awt.Choice;
import java.util.Scanner;

public class Pizzeria {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice;
		double basePrice = 0;

		System.out.println("       PIZZA MENU      ");
		System.out.println("1. Small pizza       $7");
		System.out.println("2. Medium pizza      $9");
		System.out.println("3. Large pizza       $11");
		System.out.println("4. Extra Large pizza $14");
		System.out.println("Enter your choice: ");
		choice = scanner.nextLine();
		if (choice.contains("1") || choice.contains("2") || choice.contains("3") || choice.contains("4")) {
			if (choice.contains("1"))
				basePrice += 7;
			if (choice.contains("2"))
				basePrice += 9;
			if (choice.contains("3"))
				basePrice += 11;
			if (choice.contains("4"))
				basePrice += 14;
		} else {
			System.out.println("Invalid choice!");
			System.exit(0);
		}

		System.out.println("    TOPPING MENU      ");
		System.out.println("1. Cheese      $0");
		System.out.println("2. Pepperoni   $1");
		System.out.println("3. Mushrooms   $1");
		System.out.println("4. Anchovies   $1");
		System.out.println("5. Sausage     $1");
		System.out.println("Enter your choice: ");

		choice = scanner.nextLine();
		if (choice.contains("2") || choice.contains("3") || choice.contains("4") || choice.contains("5")) {
			if (choice.contains("2"))
				basePrice += 1;
			if (choice.contains("3"))
				basePrice += 1;
			if (choice.contains("4"))
				basePrice += 1;
			if (choice.contains("5"))
				basePrice += 1;
		} else {
			System.out.println("Invalid choice!");
			System.exit(0);
		}
		System.out.println("Sir, your total bill is $"+basePrice);
	}

}
