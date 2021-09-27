import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		String name, id, choiceForRandom;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter your name ?");
		name = input.next();
		System.out.println("Enter your Id ?");
		id = input.next();

		try {
			FileWriter writer = new FileWriter(name + ".txt");
			writer.write("Name : " + name + "\n");
			writer.write("Id : " + id + "\n");
			System.out.println("Enter random numbers or the word (stop) to stop ?");
			choiceForRandom = input.next();
			while (!choiceForRandom.equals("stop")) {
				writer.write(choiceForRandom+"\n");
				choiceForRandom = input.next();
			}
			writer.write(choiceForRandom+"\n");
			System.out.println("Thank you");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
