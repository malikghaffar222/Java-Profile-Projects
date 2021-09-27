import java.util.Date;
import java.util.Calendar;

public class NonFiction extends Book {
	// extra info of Non Fiction
	private String genre;

	// =============== Constructor =================
	public NonFiction(int bookId, String title, int numPages, String genre) {
		// calling parent's constructor to initialize
		super(bookId, title, numPages);
		this.genre = genre;
	}

	// getter & setter methods for remaining attributes of this class.
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// ===implementing the abstract method of class Book===
	/*
	 * initializes the borrower, numDays and dueDate using setters
	 */
	@Override
	public boolean Borrow(String borrowerName, int numDays) {

		this.SetBorrower(borrowerName);
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, numDays);
		date = c.getTime();

		this.SetDueDate(date);
		return true;
	}

	// implementing the abstract method of class Book
	// returns the genre of this Non Fiction book
	@Override
	public String ExtraInfo() {
		return genre;
	}

	/*
	 * method to know that how many days this book can be borrowed
	 * 
	 * If the book is has numPages<500, then it returns 5 days otherwise it returns
	 * 15
	 */
	@Override

	public int getMaxBorrowDays() {
		int maxBorrowDays = 0;

		if (GetNumPages() < 500)
			maxBorrowDays = 5;

		else {
			maxBorrowDays = 15;
		}
		return maxBorrowDays;
	}
	// ============= Private Methods ===============
	/* May add your own private methods here */

	// ============= Public Methods ================
	/* May add your own public methods here */
}