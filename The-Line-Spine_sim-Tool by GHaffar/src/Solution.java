import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		List list = new List();
		while (choice != 8) {
			System.out.println("\n1. Insert details for a new node");
			System.out.println("2. Remove node from list");
			System.out.println("3. Compute the Cost of All journeys of a PaxID");
			System.out.println("4. Print All nodes with PaxID");
			System.out.println("5. Print All nodes with journeyDate");
			System.out.println("6. Print All nodes with srcModule");
			System.out.println("7. Print All nodes with destModule");
			// for exiting loop i have added a new command to exit from loop
			System.out.println("8. Exit");

			System.out.println("\nEnter your choice: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter ticketID: ");
				int ticketID = input.nextInt();
				System.out.println("Enter PaxID: ");
				int paxID = input.nextInt();
				System.out.println("Enter journeyDate(DDMMYYYY): ");
				int journeyDate = input.nextInt();
				System.out.println("Enter srcModule: ");
				int srcModule = input.nextInt();
				System.out.println("Enter destModule: ");
				int destModule = input.nextInt();
				input.nextLine(); // for line span
				System.out.println("Enter Name: ");
				String paxName = input.nextLine();

				list.insert(new Node(ticketID, paxID, journeyDate, srcModule, destModule, paxName));
				break;
			case 2:
				System.out.println("Enter paxID: ");
				paxID = input.nextInt();
				list.remove(paxID);
				break;
			case 3:
				System.out.println("Enter paxID: ");
				paxID = input.nextInt();
				System.out.println("Cost for PaxId: " + paxID + " is " + list.cost(paxID));
				break;
			case 4:
				System.out.println("Enter paxID: ");
				paxID = input.nextInt();
				list.print1(paxID);
				break;
			case 5:
				System.out.println("Enter journeyDate(DDMMYYYY): ");
				journeyDate = input.nextInt();
				list.print2(journeyDate);
				break;

			case 6:
				System.out.println("Enter srcModule: ");
				srcModule = input.nextInt();
				list.print3(srcModule);
				break;

			case 7:
				System.out.println("Enter destModule: ");
				destModule = input.nextInt();
				list.print4(destModule);
				break;

			case 8:
				System.exit(0);
				break;

			default:
				System.out.println("\nInvalid choice!\n");
				break;
			}

		}
	}

}
