
public abstract class Date212List {
	Date212Node head, first, last;
	int length;

	public Date212List() {
		first = last = head;
		length = 0;
	}

	public void append(Date212 date) {
		Date212Node node = new Date212Node(date);
		if (first == null)
			first = last = node;
		else if (last == null)
			last = node;
		else {
			last.next = node;
			last = node;
		}
		length++;
	}
}
