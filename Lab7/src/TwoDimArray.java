public class TwoDimArray {

	public static int[][] myArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	public static void main(String[] args) {
		printArray(myArray);
		System.out.println();
		printArrayEven(myArray);
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

	private static void printArrayEven(int[][] theArray) {
		for (int i = 0; i < theArray.length; i++) {
			for (int j = 0; j < theArray[i].length; j++)
				if (theArray[i][j] % 2 == 0)
					display(theArray[i][j]);
				else
					System.out.print("*" + " ");
			System.out.println();
		}
	}
}