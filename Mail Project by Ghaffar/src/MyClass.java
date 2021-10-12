import java.io.File;
import java.util.Arrays;

public class MyClass {
	int[] numbers;

	public MyClass(int[] numbers) {
		this.numbers = numbers;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public void printNumbersInAscendingOrder() {
		int[] temp = numbers;
		Arrays.sort(temp);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}

	public long getMultiplication() {
		long multiplication = 1;
		for (int i = 0; i < numbers.length; i++) {
			multiplication *= numbers[i];
		}
		return multiplication;
	}

	public int minimumNumber() {
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		return min;
	}

	public int maximumNumber() {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}
}
