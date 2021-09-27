
//import the libraries
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		ArrayList<Train> trains = new ArrayList<>(); // an array list to store references to train objects
		Scanner in = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Create a train and add it to array");
			System.out.println("2. Display number of trains created");
			System.out.println("3. Compare first two trains in array");
			System.out.println("4. Remove a train from the array (train at index i)");
			System.out.println("5. Display the trains contained in the table");
			System.out.println("6. Quit");
			System.out.print("Input your choice: ");
			choice = in.nextInt(); // get user choice from menu
			System.out.println();
			switch (choice) {
			case 1:
				// if user selects create and add train option
				System.out.print("Enter train company: ");
				String company = in.next(); // get train company from user
				System.out.print("Enter number of cars: ");
				int noOfCars = in.nextInt(); // get number of cars from user
				Type types = null;
				int type;
				do {
					// prompt user to select a type of train from following
					System.out.println("Select type(1/2/3): ");
					System.out.println("1. SLOW");
					System.out.println("2. FAST");
					System.out.println("3. TGV");
					type = in.nextInt(); // get user input for type
					switch (type) {
					case 1:
						types = Type.SLOW;
						break;
					case 2:
						types = Type.FAST;
						break;
					case 3:
						types = Type.TGV;
						break;

					default:
						// if its an invalid input then print following and prompt user again for input
						System.out.println("Invalid type!   try again...\n");
						break;
					}
				} while (type < 1 || type > 3); // loop until user enters a valid type
				trains.add(new Train(company, noOfCars, types)); // create the train object from given data of user and
																	// add to the list
				System.out.println("Successfully added.");
				System.out.println(); // line break for readability
				break;
			case 2:
				// if user selects display number of trains created option then print the number
				// of objects created by calling static method getNoOfObjects of Train class
				System.out.println("Total number of trains created is " + Train.getNoOfObjects());
				System.out.println();// line break for readability
				break;

			case 3:
				// if user selects compare 1st two trains option the do following
				if (trains.size() >= 2) { // check if there's at least two trains in list
					switch (trains.get(0).compareTo(trains.get(1))) { // compare the trains by calling compare method of
																		// Train class
					case -1:
						System.out.println("2nd train is bigger than the 1st train.");
						break;
					case 1:
						System.out.println("1st train is bigger than the 2nd train.");
						break;
					default:
						System.out.println("Both trains are equal.");
						break;
					}
				} else { // if there's no at least two trains in list the print following line
					System.out.println("There are no 2 trains in the array! try adding more trains...");
				}
				System.out.println();// line break for readability
				break;
			case 4:
				// if user selects remove train option
				System.out.println("Enter index of train to be removed: ");
				int index = in.nextInt(); // get the index of train to be removed
				if (index < trains.size()) { // if its a valid index
					trains.remove(index); // simply remove the train
					System.out.println("Successfully removed.");
				} else { // i.e if index is invalid then tell user to enter only in valid range of
							// indices
					System.out.println("Index should be in range(0-" + (trains.size() - 1) + ")!");
				}
				System.out.println();// line break for readability
				break;
			case 5:
				// if user selects display the trains option then display all trains by calling
				// toString() method
				System.out.println(trains.toString());
				System.out.println();// line break for readability
				break;
			case 6:
				// if user selects quit option then exit program after printing following line
				System.out.println("Successfully quit.");
				System.exit(0);
				break;

			default:
				// if its an invalid choice then print following
				System.out.println("Invalid choice! try again...\n");
				break;
			}
		} while (choice != 6); // loop until user enters 6
	}

}
