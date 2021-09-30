import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileInput {

	public static void main(String[] args) {
		int [][] arrayReturned=fillArray("twodimension.txt");
		printArray(arrayReturned);

	}

	public static int[][] fillArray(String myFile) {
		try {
			File readFile = new File(myFile);
			Scanner fileScanner = new Scanner(readFile);
			int rows = Integer.parseInt(fileScanner.nextLine());
			int cols = Integer.parseInt(fileScanner.nextLine());
			int[][] twoDimArray = new int[rows][cols];
			for (int i = 0; i < twoDimArray.length; i++) {
				for (int j = 0; j < twoDimArray[i].length; j++) {
					twoDimArray[i][j] = Integer.parseInt(fileScanner.nextLine());
				}
			}
			return twoDimArray;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// returning an empty array
			return new int[][] {};
		}

	}

	private static void printArray(int[][] theArray) {
		for (int i = 0; i < theArray.length; i++) {
			for (int j = 0; j < theArray[i].length; j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}

	private static void display(int num) {
		System.out.print(num + " ");
	}

}
