import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Assignment {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int enteredNumber = 0;
		char choice;
		ArrayList<Integer> theList = new ArrayList<>();
		ArrayList<Integer> listToRemove = new ArrayList<>();
		do {
			System.out.println("Please enter a positive integer or zero to end> ");
			enteredNumber = input.nextInt();
			if (enteredNumber > 0)
				theList.add(enteredNumber);
		} while (enteredNumber != 0);

		System.out.println("Do you want to remove? Y/N: ");
		choice = input.next().charAt(0);
		if (choice == 'Y' || choice == 'y') {
			System.out.println("Enter the integer(s) to be removed");
			int number;
			while (true) {
				number = input.nextInt();
				if(number==KeyEvent.VK_ENTER)
					break;
				if (number > 0)
					listToRemove.add(number);
			}
			//System.out.println(listToRemove);

		} else {
			System.out.println("End of the program.");
		}

	}

	// method to convert a string array that contains integers into integer array
	private static int[] stringToIntArray(String[] strings) {
		int[] integers = new int[strings.length];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(strings[i]);
		}
		return integers;
	}

}
