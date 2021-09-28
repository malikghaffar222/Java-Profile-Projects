import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFromFile {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("student.txt"));
			System.out.println("student.txt");
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				System.out.print(s.substring(s.indexOf(":") + 1));
				s = scanner.nextLine();
				System.out.print(s.substring(s.indexOf(":") + 1));
				s = scanner.nextLine();
				System.out.print(s.substring(s.indexOf(":") + 1));
				s = scanner.nextLine();
				System.out.print(s.substring(s.indexOf(":") + 1));
				s = scanner.nextLine();
				System.out.print(s.substring(s.indexOf(":") + 1));
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
