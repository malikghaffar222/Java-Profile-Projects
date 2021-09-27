import java.util.ArrayList;

public class Book {
	protected String title;
	protected Publisher publisher;
	protected ArrayList<Author> authors;

	public Book(String title) {
		this.title = title;
	}

	public void addAuthor(Author a) {
		authors.add(a);
	}
}
