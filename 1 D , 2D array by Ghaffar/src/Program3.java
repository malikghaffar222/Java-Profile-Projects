import java.util.Random;
import java.util.Scanner;

public class Program3 {
	public static boolean identical(int[] a1, int[] a2) {
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a1[], a2[];
		do {
			System.out.println("Enter size of first array: ");
			int size = in.nextInt();
			a1 = new int[size];

			System.out.println("Enter size of first array: ");
			size = in.nextInt();
			a2 = new int[size];

			if (a1.length != a2.length)
				System.out.println("Size of both arrays should be same!");
		} while (a1.length != a2.length);

		for (int i = 0; i < a1.length; i++) {
			System.out.println("Enter a1[" + i + "]: ");
			a1[i] = in.nextInt();
		}
		System.out.println();
		for (int i = 0; i < a2.length; i++) {
			System.out.println("Enter a2[" + i + "]: ");
			a2[i] = in.nextInt();
		}
		System.out.println("Arrays are identical: " + identical(a1, a2));
	}

}
