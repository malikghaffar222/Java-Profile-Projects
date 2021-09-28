
import java.io.File;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Window window1 = new Window("User1's", "Window1");
		Window window2 = new Window("User2's", "Window2");
		window2.frmWindow.setBounds(640, 110, 570, 400);

	}

	public static String data() {
		String line = "";
		try {
			File file = new File("Program Action.txt");
			if (!file.exists())
				file.createNewFile();
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				line += scan.nextLine();
			}
			return line;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return line;
	}

}
