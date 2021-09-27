import java.util.Date;
import java.util.Calendar;

public class Novel extends Book {
	// extra info of novel
	private boolean isUsedInEng;

	// =============== Constructor =================
	public Novel(int bookId, String title, int numPages, boolean isUsedInEng) {
		super(bookId, title, numPages);
		this.isUsedInEng = isUsedInEng;
	}

	// getter & setter methods for remaining attributes of this class.
	public boolean isUsedInEng() {
		return isUsedInEng;
	}

	public void setUsedInEng(boolean isUsedInEng) {
		this.isUsedInEng = isUsedInEng;
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

	// ===implementing the abstract method of class Book===
	@Override
	public String ExtraInfo() {
		// if the books is used in English classes then return true otherwise false
		if (isUsedInEng)
			return "true";
		else
			return "false";
	}

	/*
	 * method to know that how many days this book can be borrowed
	 * 
	 * If the book is for used English classes, then it may borrow only up to 30
	 * days
	 */

	public int getMaxBorrowDays() {
		int maxBorrowDays = 0;

		if (isUsedInEng)
			maxBorrowDays = 30;
		else {
			maxBorrowDays = (int) Math.ceil((GetNumPages() / 20) * 1.25);
		}
		return maxBorrowDays;
	}

	// ============= Private Methods ===============
	/* May add your own private methods here */

	// ============= Public Methods ================
	/* May add your own public methods here */
}