import java.util.Scanner;

public class quiz1_StudentID_2 {

	public static void main(String[] args) {
		String string;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		string = input.nextLine();
		System.out.println("Encrypted string : " + encrypt(string));
	}

	public static String encrypt(String s) {
		String encryptedString = "";
		for (int i = 0, l = 13; i < s.length(); i++) {
			int c = s.charAt(i) + 13;
			if (c > 90 && c < 97)
				c = c - 90 + 65;
			else if (c > 122)
				c = c - 122 + 97;
			encryptedString += (char)c + "";
		}

		return encryptedString;
	}

}
