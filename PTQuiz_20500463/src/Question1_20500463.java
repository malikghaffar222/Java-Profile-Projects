import java.io.File;
import java.util.Scanner;

/**
 * @id 20500463
 * @name Mariana Sofia Morales Rueda
 * @campus Sydney
 * @tutor Chris Stanton
 *
 */
public class Question1_20500463 {

	public static void main(String[] args) {

		try {
			// opening file
			File file = new File("batsmen.txt");
			String highestAverageBatsman = ""; // for storing highest average batsman name
			float highestAverage = 0; // for storing highest average value of batsmen
			// do if and only if the file exists
			if (file.exists()) {
				// using scanner object to read data from file
				Scanner fileRead = new Scanner(file);
				// formatting headers with prinf
				System.out.printf("%-20s%-15s%-20s", "Name", "Matches", "Average Score Per Innings\n");
				// to print dashes
				for (int i = 0; i < 70; i++) {
					System.out.print("-");
				}
				// for line break
				System.out.println();
				// if the file has more data till that loop through each of its line
				while (fileRead.hasNextLine()) {
					// get current line
					String[] currentLine = fileRead.nextLine().split(",");
					// storing name,matces & average per innings
					String name = currentLine[0];
					int matches = Integer.parseInt(currentLine[1]);
					int numberOfInnings = Integer.parseInt(currentLine[2]);
					int totalRuns = Integer.parseInt(currentLine[3]);
					float averagePerInnings = (float) totalRuns / numberOfInnings;
					if (highestAverage < averagePerInnings) {
						highestAverage = averagePerInnings;
						highestAverageBatsman = name;
					}
					// formatting data w.r.t headers
					System.out.printf("%-20s%-15s%-20.05s\n", name, matches, averagePerInnings);
				}
				System.out.println(
						"The batsman with highest average score per innings is " + highestAverageBatsman + ".");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
