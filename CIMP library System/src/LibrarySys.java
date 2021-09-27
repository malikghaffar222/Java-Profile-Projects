
public class LibrarySys {
	private BookShelfDB bookShelf; // BookShelfDB object (DO NOT MODIFY)

	// =============== Constructor =================
	// initializes the bookShelf object
	public LibrarySys() {
		bookShelf = new BookShelfDB();
	}

	// ============= Private Methods ===============
	/* May add your own private methods here */

	// ============= Public Methods ===============
	/*
	 * Import books info and fill up the BookShelfDB object from a textfile
	 * 
	 * @param filename - The filename that the system will add books from
	 * 
	 * @return - The number of books added
	 */
	public int ImportBooks(String filename) {
		// calling AddBook function of Bookshelf class to add Books from given file
		int numOfBooksAdded = bookShelf.AddBook(filename);

		// displaying the total number of books imported to the bookshelf
		System.out.println("Added " + numOfBooksAdded + " to the system from " + filename);
		return numOfBooksAdded;
	}

	/*
	 * To add an individual book
	 * 
	 * @param bookType - The booktype that you are adding (refer back to the Book
	 * class for the value of each type
	 * 
	 * @param title - The title of the book
	 * 
	 * @param numPages - Number of pages for the book to be added
	 * 
	 * @param extraInfo - Special information. Specific to book type
	 * 
	 * @return - Return true if the book is successfully added. Return false if the
	 * bookType value is incorrect.
	 */
	public boolean AddBook(int bookType, String title, int numPages, String extraInfo) {
		// Determine the book type and create the appropriate
		// book object for it.
		Book newBook = null;
		boolean status; // used to check if the book is added or not
		switch (bookType) {
		case Book.HISTORY:
			newBook = new History(bookType, title, numPages, extraInfo);
			// the book has been successfully added
			status = true;
			break;
		case Book.NON_FICTION:
			newBook = new NonFiction(bookType, title, numPages, extraInfo);
			status = true;
			break;
		case Book.NOVEL:
			// As the novel will contain extraInfo is represented by true similarly
			// the novel won't contain extraInfo is represented by false
			if (extraInfo.equals(""))
				newBook = new Novel(bookType, title, numPages, false);
			else
				newBook = new Novel(bookType, title, numPages, true);
			status = true;
			break;
		default:
			System.out.println("Invalid BooksType!");
			status = false;
			break;
		}
		// if status is true(i.e booktype is valid and the corresponding book is
		// initialized)
		// then add the book initialized above
		if (status) {
			// generating new book id for this book
			newBook.setBookId(bookShelf.GenNewBookId());
			bookShelf.AddBook(newBook);
			System.out.println("\nSuccesfully added the book '" + newBook.GetTitle() + "'");
		}
		return status;
	}

	/* Displays all the books */
	public void DisplayAllBooks() {
		// getting total number of books in our bookshelf object.
		int totalNumOfBooks = bookShelf.NumBooks();
		if (totalNumOfBooks > 0) {
			// printing header
			System.out.printf("%10s", "Book ID");
			System.out.printf("%15s", "Book Type");
			System.out.printf("%40s", "Title");
			System.out.printf("%15s", "Num Page");
			System.out.printf("%20s", "Extra Info");
			System.out.printf("%30s", "Borrower");
			System.out.printf("%15s\n", "Due Date");

			// printing equal sign the total sum of indented spaces times
			printSign(10 + 15 + 40 + 15 + 20 + 30 + 15, '=');

		}
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			displayBookInfo(loopBook);
		}
	}

	/* Displays all the history books */
	public void DisplayHistoryBooks() {
		// getting total number of books in our bookshelf object.
		int totalNumOfBooks = bookShelf.NumBooks();
		if (totalNumOfBooks > 0) {
			// printing header
			System.out.printf("%10s", "Book ID");
			System.out.printf("%15s", "Book Type");
			System.out.printf("%40s", "Title");
			System.out.printf("%15s", "Num Page");
			System.out.printf("%20s", "Period");
			System.out.printf("%30s", "Borrower");
			System.out.printf("%15s\n", "Due Date");

			// printing equal sign the total sum of indented spaces times
			printSign(10 + 15 + 40 + 15 + 20 + 30 + 15, '=');

		}
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			// if it is a history book then print it otherwise do nothing to this book
			if (GetBookTypeName(loopBook).equalsIgnoreCase("History"))
				displayBookInfo(loopBook);
		}
	}

	/* Displays all the non-fiction books */
	public void DisplayNonFictionBooks() {
		// getting total number of books in our bookshelf object.
		int totalNumOfBooks = bookShelf.NumBooks();
		if (totalNumOfBooks > 0) {
			// printing header
			System.out.printf("%10s", "Book ID");
			System.out.printf("%15s", "Book Type");
			System.out.printf("%40s", "Title");
			System.out.printf("%15s", "Num Page");
			System.out.printf("%20s", "Period");
			System.out.printf("%30s", "Borrower");
			System.out.printf("%15s\n", "Due Date");

			// printing equal sign the total sum of indented spaces times
			printSign(10 + 15 + 40 + 15 + 20 + 30 + 15, '=');

		}
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			// if it is a Non Fiction book then print it otherwise do nothing to this book
			if (GetBookTypeName(loopBook).equalsIgnoreCase("NonFiction"))
				displayBookInfo(loopBook);
		}
	}

	/* Displays all the novel books */
	public void DisplayNovelBooks() {
		// getting total number of books in our bookshelf object.
		int totalNumOfBooks = bookShelf.NumBooks();
		if (totalNumOfBooks > 0) {
			// printing header
			System.out.printf("%10s", "Book ID");
			System.out.printf("%15s", "Book Type");
			System.out.printf("%40s", "Title");
			System.out.printf("%15s", "Num Page");
			System.out.printf("%20s", "Period");
			System.out.printf("%30s", "Borrower");
			System.out.printf("%15s\n", "Due Date");

			// printing equal sign the total sum of indented spaces times
			printSign(10 + 15 + 40 + 15 + 20 + 30 + 15, '=');

		}
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			// if it is a Novel book then print it otherwise do nothing to this book
			if (GetBookTypeName(loopBook).equalsIgnoreCase("Novel"))
				displayBookInfo(loopBook);
		}
	}

	/*
	 * Determines the book type name base on the Book object.
	 * 
	 * @param book - The Book object
	 * 
	 * @return - Returns the book type of the book in String Returns null if the
	 * Book object is not one of of the 3 books.
	 */
	public String GetBookTypeName(Book book) {
		// get the book type
		return book.getClass().getName();
	}

	/*
	 * Borrow a book
	 * 
	 * @param code - The book code (generated by the book counter)
	 * 
	 * @param borrower - The borrower's name
	 * 
	 * @return - Returns 1 if the borrowing process went through. Returns 0 if the
	 * book ID doesn't exist in the system. Returns -1 if the number of days doesn't
	 * satisfy the book borrowing rules. Returns -2 if someone else borrowed the
	 * book already.
	 */
	public int BorrowBook(int bookId, String borrower, int numDays) {
		// getting total number of books in our bookshelf object.
		int totalNumOfBooks = bookShelf.NumBooks();
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			// comparing if any book exists with this id
			if (loopBook.GetBookId() == bookId) {
				// if number of days is greater than the number of days that can be borrowed
				if (numDays > loopBook.getMaxBorrowDays()) {
					System.out.println(
							"\nThe number for borrowing this book can not exceed " + loopBook.getMaxBorrowDays() + "!");
					return -1;
				}
				// if book has already a borrower return -2
				if (!loopBook.GetBorrower().equals("")) {
					System.out.println("\nThis book is already borrowed!");
					return -2;
				}
				// if above conditions are evaluated to false that means it is being processed
				if (loopBook.Borrow(borrower, numDays)) {
					System.out.println("\nSuccessfully borrow book.");
					return 1;
				}
			}
		}
		// no any book exist with this book id
		System.out.println("\nNo any book exist for id " + bookId + "\n");
		return 0;
	}

	/*
	 * Returns the book to the library
	 * 
	 * @param code - The book code of the book to be returned
	 * 
	 * @return - Returns 2 if it is able to return and processed. Returns 0 if the
	 * book ID is not in the system. Returns -3 if the book was not borrowed.
	 */
	public int ReturnBook(int bookId) {
		int totalNumOfBooks = bookShelf.NumBooks();
		// this will refer to the loop book and using it we will print information
		Book loopBook;
		for (int i = 0; i < totalNumOfBooks; i++) {
			loopBook = bookShelf.GetBookAt(i);
			// comparing if any book exists with this id
			if (loopBook.GetBookId() == bookId) {
				// if book has no any borrower return -3
				if (loopBook.GetBorrower() == null) {
					System.out.println("\nBook has no an borrower.");
					return -3;
				}
				// if above condition is evaluated to false that means it is being processed
				loopBook.Return();
				System.out.println("\nSuccessfully return book.");
				return 2;
			}
		}
		// no any book exist with this book id
		System.out.println("\nNo any book exist for id " + bookId + "!\n");
		return 0;
	}

	/*
	 * @param code - The book object whose data is to be displayed
	 * 
	 * helper method that prints the data of book that comes as an argument
	 */
	private void displayBookInfo(Book b) {
		System.out.printf("%10d", b.GetBookId());
		System.out.printf("%15s", GetBookTypeName(b));
		System.out.printf("%40s", b.GetTitle());
		System.out.printf("%15s", b.GetNumPages());
		System.out.printf("%20s", b.ExtraInfo());
		System.out.printf("%30s", b.GetBorrower());
		System.out.printf("%15s\n", b.GetDueDate());
	}

	/*
	 * @param code - the number of times one wants to display '=' sign
	 * 
	 * helper method that prints the equal sign that number of times that comes as
	 * an argument
	 */
	public void printSign(int numberOfTimes, char sign) {
		for (int i = 0; i < numberOfTimes; i++) {
			System.out.print(sign);
		}
		// if its a equal sign then print the statement after this method on next line
		if (sign == '=')
			System.out.println();
	}

}