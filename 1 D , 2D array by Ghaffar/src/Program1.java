import java.util.Random;

public class Program1 {

	public static void main(String[] args) {
		int a1d[] = new int[64];
		for (int i = 0; i < a1d.length; i++) {
			a1d[i] = (int) (new Random().nextInt(91) + 10); // +1 for including 100
		}
		int a2d[][] = new int[8][8];
		int counter = 0;

		for (int i = 0; i < a2d.length; i++) {
			for (int j = 0; j < a2d[i].length; j++) {
				a2d[i][j] = a1d[counter++];
			}
		}
		for (int[] is : a2d) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}

		int sum = 0;

		for (int i = 0; i < a2d.length; i++) {
			for (int j = 0; j < a2d[i].length; j++) {
				if (i == j)
					sum += a2d[i][j];
			}
		}

		System.out.println("Sum of main diagonal of 2D array is : " + sum);
	}

}
