import java.util.ArrayList;

public class ScientificBook extends Book {
	public ScientificBook(String title) {
		super(title);
	}

	protected ArrayList<ScientificField> fields;

	public void addScientificField(ScientificField f) {
		fields.add(f);
	}

	public void addAuthor(Author a) {
		authors.add(a);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
