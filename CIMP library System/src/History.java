import java.util.Date;
import java.util.Calendar;

public class History extends Book {
	// extra info of History
	private String historyPeriod;

	// =============== Constructor =================
	public History(int bookId, String title, int numPages, String historyPeriod) {
		// calling parent's constructor to initialize
		super(bookId, title, numPages);
		this.historyPeriod = historyPeriod;
	}

	// getter & setter methods for remaining attributes of this class.
	public String getHistoryPeriod() {
		return historyPeriod;
	}

	public void setHistoryPeriod(String historyPeriod) {
		this.historyPeriod = historyPeriod;
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
	// returns the history period of this history book
	@Override
	public String ExtraInfo() {
		return historyPeriod;
	}

	/*
	 * method to know that how many days this book can be borrowed
	 * 
	 * returns 10 i.e maximum number of days a history book can be borrowed
	 */
	@Override

	public int getMaxBorrowDays() {
		return 10;
	}
	// ============= Private Methods ===============
	/* May add your own private methods here */

	// ============= Public Methods ================
	/* May add your own public methods here */
}