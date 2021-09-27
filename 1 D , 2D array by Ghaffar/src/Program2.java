import java.util.Random;
import java.util.Scanner;

public class Program2 {

	public static int[] followArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];

		int counter = 0;
		for (int i = 0; i < a1.length; i++)
			a3[counter++] = a1[i];

		for (int i = 0; i < a2.length; i++)
			a3[counter++] = a2[i];

		System.out.println("resulting array: ");
		for (int i : a3)
			System.out.print(i + " ");
		return a3;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int a1[], a2[];
		System.out.println("Enter size of first array: ");
		int size = in.nextInt();
		a1 = new int[size];

		System.out.println("Enter size of first array: ");
		size = in.nextInt();
		a2 = new int[size];

		for (int i = 0; i < a1.length; i++)
			a1[i] = r.nextInt(46) + 5;// as 50 is inclusive
		for (int i = 0; i < a2.length; i++)
			a2[i] = r.nextInt(46) + 5;// as 50 is inclusive
		followArrays(a1, a2);
	}

}
