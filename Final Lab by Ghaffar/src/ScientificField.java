import java.util.ArrayList;

public class ScientificField {
	protected String name;
	protected ArrayList<ScientificBook> books;

	public ScientificField() {
	}

	public void addScientificBook(ScientificBook b) {
		books.add(b);
	}
}
