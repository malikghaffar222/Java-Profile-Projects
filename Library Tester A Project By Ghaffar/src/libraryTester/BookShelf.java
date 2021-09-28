package libraryTester;

import java.util.ArrayList;

public class BookShelf implements Operations{
	char bookCharacter;
	ArrayList<Book> books;
	int noOfBooks;

	public BookShelf() {
		bookCharacter = ' ';
		books = new ArrayList<Book>();
		noOfBooks = 0;
	}

	public char getBookCharacter() {
		return bookCharacter;
	}

	public void setBookCharacter(char bookCharacter) {
		this.bookCharacter = bookCharacter;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public void addBook(Book book) {
		if (book.toString().charAt(0) == bookCharacter)
			books.add(book);
		else
			return;
	}

	public void removeBook(Book book) {
		if (book.toString().charAt(0) == bookCharacter)
			books.remove(book);
		else
			return;
	}

	@Override
	public String toString() {
		String buf = "";
		if (books.isEmpty())
			return ("Empty");

		for (Object book : books) {
			buf += ((Book) book + "   ");
		}
		return buf;
	}
}
