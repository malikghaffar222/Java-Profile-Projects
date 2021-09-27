import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		double incomeRead[] = new double[8];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < incomeRead.length; i++) {
			System.out.print("Enter an income: ");
			incomeRead[i] = Math.ceil(in.nextDouble());
		}
		System.out.println("The incomes are: ");
		for (double d : incomeRead) {
			System.out.print(d + "\t");
		}
		double max = incomeRead[0], avg = 0;
		for (int i = 0; i < incomeRead.length; i++) {
			avg += incomeRead[i];
			if (incomeRead[i] > max)
				max = incomeRead[i];
		}
	}

}
