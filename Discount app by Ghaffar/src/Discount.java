import java.util.Scanner;

public class Discount {
	public static boolean isCorrectAccount(String account) {
		boolean numbersOnly = false;
		for (int i = 0; i < account.length(); i++) {
			char c = account.charAt(i);
			if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
					|| c == '8' || c == '9'))
				return false;
		}
		return account.length() == 8;
	}

	public static boolean isValidBasicDiscount(int discount) {
		return (discount == 5 || discount == 10 || discount == 15 || discount == 20);
	}

	public static void printDiscountAmount(int basicDiscount, String cardType) {
		double discountAmount = 0;
		if (cardType.equals("student")) {
			discountAmount = 0.01 + Math.pow(basicDiscount, 1.1) / 100;
		} else if (cardType.equals("premium")) {
			discountAmount = 1.5 * (basicDiscount / 100);
		} else {
			discountAmount = basicDiscount / 100;
		}
		if (cardType.equals("employee"))
			System.out.printf("Insurance amount = %f", discountAmount);
		else
			System.out.printf("Discount amount = %f", discountAmount);
	}

	public static void main(String[] args) {
		String an, dt;
		Scanner in = new Scanner(System.in);
		int bd;
		System.out.println("Enter the account number: ");
		an = in.next();
		System.out.println("Enter the basic discount: ");
		bd = in.nextInt();
		System.out.println("Enter the card type: ");
		dt = in.next();
		if (!isCorrectAccount(an))
			System.out.println("Invalid account number!");
		if (!isValidBasicDiscount(bd))
			System.out.println("Invalid basic discount!");
		if (isCorrectAccount(an) && isValidBasicDiscount(bd)) {
			printDiscountAmount(bd, dt);
		}

	}

}
