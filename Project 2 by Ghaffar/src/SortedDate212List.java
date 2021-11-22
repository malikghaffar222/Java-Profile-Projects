
public class SortedDate212List extends Date212List {
	public SortedDate212List() {
		super();
	}

	void add(Date212 date) {
		Date212Node node = new Date212Node(date);
		if (first == null)
			first = last = node;
		else if (first.data.compareTo(date) == 1) {
			node.next = first;
			first = node;
		} else if (first.next == null) {
			node.next = first.next;
			first.next = node;
		} else {

			Date212Node current = first;
			Date212Node previous = current;
			while (current.data.compareTo(date) != 1) {
				previous = current;
				current = current.next;
				if (current == null)
					break;
			}
			previous.next = node;
			previous.next.next = current;
		}
		length++;
	}
}
