import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("numbers.txt");
			if (file.createNewFile() || file.exists()) {
				FileWriter writetoFile = new FileWriter(file);
				Random random = new Random();
				for (int i = 0; i < 20; i++) {
					/**
					 * will generate numbers from 0 to 200 and after subtraction of 100 it will be
					 * in range -100 to +100 201 bcz we have to include 100 too
					 **/
					int randomNumber = random.nextInt(201) - 100;
					writetoFile.write(randomNumber + " ");
				}
				writetoFile.close();
				System.out.println("File Created.");
				Scanner readFile = new Scanner(file);
				String line = readFile.nextLine();
				String[] array = line.split(" ");
				MyClass class1 = new MyClass(convertToIntArray(array));
				System.out.println("Numbers in ascending Order: ");
				class1.printNumbersInAscendingOrder();
				System.out.println("Multiplication of Numbers is: " + class1.getMultiplication());
				System.out.println("Minimum Value inputted: " + class1.minimumNumber());
				System.out.println("Maximum Value inputted: " + class1.maximumNumber());
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	private static int[] convertToIntArray(String[] array) {
		int[] intArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}

		return intArray;
	}

}
