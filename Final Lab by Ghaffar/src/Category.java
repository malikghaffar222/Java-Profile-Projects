import java.util.ArrayList;

public class Category {
	protected String name, code, description;
	protected ArrayList<LiteratureBook> books;

	public Category() {
	}

	public void addLiteratureBook(LiteratureBook b) {
		books.add(b);
	}
}
