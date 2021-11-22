
// import statements  
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class Date212GUI {
	JFrame frameObj;

// constructor  
	Date212GUI() throws FileNotFoundException {
		frameObj = new JFrame();

		SortedDate212List sortedDateList = new SortedDate212List();
		UnsortedDate212List unsortedDateList = new UnsortedDate212List();

		Scanner fileScanner = new Scanner(new File("input.txt"));

		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine();

			String[] lineArray = line.split(",");

			for (String date : lineArray) {
				sortedDateList.add(new Date212(date));
				unsortedDateList.add(new Date212(date));
			}
		}

		TextArea txt1 = new TextArea("Unsorted Date List\n");
		TextArea txt2 = new TextArea("Sorted Date List\n");

		for (Date212Node temp = unsortedDateList.first; temp != null; temp = temp.next) {
			txt1.setText(txt1.getText() + temp.data + "\n");

		}

		for (Date212Node temp = sortedDateList.first; temp != null; temp = temp.next) {
			txt2.setText(txt2.getText() + temp.data + "\n");

		}

		frameObj.add(txt1);
		frameObj.add(txt2);

		frameObj.setLayout(new GridLayout());

		frameObj.setSize(600, 600);
		frameObj.setVisible(true);
	}

}