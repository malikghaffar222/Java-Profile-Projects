import java.io.File;
import java.util.Scanner;

public class Program {
	
	//method to read data from file
	public static int[] readData(Scanner scanner, int[] array, int n) {
		// added try catch for handling exceptions like if file has not enough values or
		// has no any data etc
		try {
			// open file for reading
			scanner = new Scanner(new File("file1.txt"));
			n = scanner.nextInt();
			// initialize array with size n
			array = new int[n];
			// reading from file and adding elements in array
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			System.out.println("Succesfully inserted the " + n + " elements in the array.");
			return array;
		} catch (Exception e) {
			e.printStackTrace();
			return array;
		}

	}

	//method to count total number of zeros in array
	public static int countzeros(int[] array, int n) {
		int zeros = 0;
		// comparing each element for equality with zero if it is equal then increment
		// zeros
		for (int i = 0; i < n; i++) {
			if (array[i] == 0)
				zeros++;
		}
		return zeros;
	}

	//method to add remaining elements to the array
	public static int[] append(Scanner scanner, int[] array, int n) {
		try {
			scanner = new Scanner(new File("file1.txt"));
			// skipping the previous elements
			n = scanner.nextInt();
			for (int i = 0; i < n; i++)
				scanner.nextInt();
			// adding remaining elements
			while (scanner.hasNextInt()) {
				n++;
				int[] oldarray = array;
				array = new int[n];
				System.arraycopy(oldarray, 0, array, 0, oldarray.length);
				array[n - 1] = scanner.nextInt();
			}
			System.out.println("Succesfully appended the remaining elements in the array.");
			return array;
		} catch (Exception e) {
			e.printStackTrace();
			return array;
		}
	}

	//method to print elements of the array
	public static void printData(int[] array, int n) {
		System.out.print("\nArrays Values are: ");
		// printing the elements
		for (int i = 0; i < n; i++) {
			if (n > 10 && i % 10 == 0)
				System.out.println(); // nothing, just printing only ten elements a line
			System.out.print(array[i] + " ");

		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		int n = 0;
		int[] array = new int[n];
		Scanner scan = null;
		array = readData(scan, array, n);
		n = array.length;

		printData(array, n);

		int count = countzeros(array, n);
		System.out.println("The number of zeros in the first " + n + " elements of the array is " + count + ".");

		array = append(scan, array, n);
		n = array.length;
		printData(array, n);

		count = countzeros(array, n);
		System.out.println("The number of zeros in the first " + n + " elements of the array is " + count + ".");

	}
}
