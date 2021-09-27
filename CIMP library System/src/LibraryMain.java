import java.util.Scanner;

public class LibraryMain {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// The LibarySys object that manages the books
		LibrarySys libSys = new LibrarySys();
		int choice; // for validating user's input

		// end loop only if choice=6 otherwise don't terminate
		while (true) {
			printText("CIMP LIBRARY SYSTEM");
			System.out.println("1. Add Books from File");
			System.out.println("2. Add Single Book");
			System.out.println("3. Display Books");
			System.out.println("4. Borrow Book");
			System.out.println("5. Return Book");
			System.out.println("6. Exit");

			System.out.print("Choose an option: ");
			choice = input.nextInt(); // get user input
			System.out.println("\n"); // insert new line for readability purpose

			switch (choice) {
			case 1:
				libSys.ImportBooks("BookList.txt");
				System.out.println("\n"); // for good readability add new line
				break;
			case 2:
				printText("Add Single Books");
				System.out.println("Book Type");
				System.out.println("1. History");
				System.out.println("2. Non Fiction");
				System.out.println("3. Novel");
				System.out.print("Enter Book Type: ");
				int bookType = input.nextInt();
				// validating the type of book if it is not in(1,2,3) then skip the iteration of
				// loop
				if (bookType < 1 || bookType > 3) {
					System.out.println("Invalid choice!...try again!");
					System.out.println("\n");
					continue;
				}
				// for a scanner object to work properly if nextInt() or next() methods are
				// called
				// along with nextLine() in the same program then it is necessary to call
				// nextLine() after next() or nextInt() methods
				input.nextLine();
				System.out.print("Enter Book Title: ");
				String title = input.nextLine();
				System.out.print("Enter Book Number of Pages: ");
				int numPages = input.nextInt();
				input.nextLine();
				String extraInfo;
				switch (bookType) {
				case 1:
					System.out.print("Enter Book History Period: ");
					break;
				case 2:
					System.out.print("Enter Book Non Fiction Genre: ");
					break;
				case 3:
					System.out.print("Is this Novel used in English?  ");
					break;

				}
				extraInfo = input.nextLine();
				// bookType-1 because we have options from 1 to 3 but book types are from 0 to 2
				libSys.AddBook(bookType - 1, title, numPages, extraInfo);
				System.out.println("\n");
				break;
			case 3:
				printText("Display Books");
				System.out.println("Books to Display");
				System.out.println("1. All");
				System.out.println("2. History only");
				System.out.println("3. Non Fiction only");
				System.out.println("4. Novel only");
				System.out.print("Enter Display Option: ");
				int displayChoice = input.nextInt();
				System.out.println();
				// validating the type of book if it is not in(1,2,3) then skip the iteration of
				// loop
				switch (displayChoice) {
				case 1:
					libSys.DisplayAllBooks();
					break;
				case 2:
					libSys.DisplayHistoryBooks();
					break;
				case 3:
					libSys.DisplayNonFictionBooks();
					break;

				case 4:
					libSys.DisplayNovelBooks();
					break;
				default:
					System.out.println("Invalid choice!...try again!");
					System.out.println("\n");
					continue;
				}
				System.out.println("\n");
				break;
			case 4:
				printText("Borrow Books");
				System.out.print("Enter Book ID to borrow: ");
				int bookId = input.nextInt();
				input.nextLine();
				System.out.print("Enter borrower's name: ");
				String borrowerName = input.nextLine();
				System.out.print("Enter number of days to borrow: ");
				int numDays = input.nextInt();

				libSys.BorrowBook(bookId, borrowerName, numDays);
				System.out.println();
				System.out.println("\n");
				break;
			case 5:
				printText("Return Book");
				System.out.print("Enter Book ID to return: ");
				bookId = input.nextInt();
				libSys.ReturnBook(bookId);
				System.out.println("\n");
				break;
			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice!...try again!");
				System.out.println();
			}
		}
	}

	/*
	 * helper Method to print header of screen
	 */
	private static void printText(String text) {
		LibrarySys temp = new LibrarySys();
		temp.printSign(40, '=');

		// calculating indent length that how many spaces should it print
		int indentLength = (40 - text.length()) / 2;
		System.out.print("|");

		// print spaces before the text indentLength-1 times because one space is
		// occupied by| above
		temp.printSign(indentLength - 1, ' ');

		// print the text
		System.out.print(text.toUpperCase());

		// this one is for right indentation
		temp.printSign(indentLength, ' ');
		System.out.print("|\n");
		temp.printSign(40, '=');
	}

}