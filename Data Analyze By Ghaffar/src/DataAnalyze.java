import java.util.Scanner;

public class DataAnalyze {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter a sample size: ");
		int sampleSize = in.nextInt();
		// if input is invalid i.e negative or zero then end program
		if (sampleSize <= 0) {
			System.out.println("No data to analyze. Ending program.");
			System.exit(0);
		}
		/*
		 * creating two dimensional array each row representing corresponding trial and
		 * each column representing samples in each trial
		 * 
		 * size is 4 as we have four trials
		 */

		int[][] trials = new int[4][sampleSize];
		for (int i = 1; i <= trials.length; i++) {
			System.out.println("\nEnter numbers for Trial " + i);
			int j = 1;
			while (j <= sampleSize) {
				System.out.print("Enter sample #" + j + ": ");
				trials[i - 1][j - 1] = in.nextInt();
				j++;
			}
		}
		System.out.println("\n\tSample #\tTrial 1\tTrial 2\tTrial 3\tTrial 4");
		for (int j = 1; j <= sampleSize; j++) {
			System.out.printf("\t%d%18d%8d%8d%8d\n", j, trials[0][j - 1], trials[1][j - 1], trials[2][j - 1],
					trials[3][j - 1]);
		}
		System.out.println("\t-----------------------------------------------");
		System.out.print("Averages:      ");
		double avg[] = new double[trials.length];
		for (int i = 0; i < trials.length; i++) {
			avg[i] = 0;
			for (int j = 0; j < sampleSize; j++) {
				avg[i] += trials[i][j]; // finding sum first
			}
			avg[i] /= sampleSize; // finding average now
		}
		System.out.printf("\t%12.1f%8.1f%8.1f%8.1f\n", avg[0], avg[1], avg[2], avg[3]); // rounding the average
		// values
		// finding min & max average
		double min = avg[0], max = avg[0];
		for (int i = 1; i < avg.length; i++) {
			if (avg[i] > max)
				max = avg[i];
			if (avg[i] < min)
				min = avg[i];
		}
		System.out.println("\nMin Average: " + min);
		System.out.println("Max Average: " + max);
		if (min == max)
			System.out.println("\nThe trials match EXACTLY!");
		else if (max < (2 * min))
			System.out.println("\nThe trials concur with each other!");
		else
			System.out.println("\nThe trials do NOT concur!");
	}
}
