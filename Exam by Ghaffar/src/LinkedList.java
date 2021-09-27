
public class LinkedList {
	int number;
	LinkedList next;

	public LinkedList(int n) {
		number = n;
	}

	public void insert(int n) {
		if (next == null)
			next = new LinkedList(n);
		else {
			LinkedList list = next;
			while (list.next != null) {
				list = list.next;
			}
			list.next = new LinkedList(n);
		}
	}

	public void display() {
		System.out.println(number);
		LinkedList list = next;
		while (list != null) {
			System.out.println(list.number);
			list = list.next;
		}
	}

	public void displayEvenNumbers() {
		if (number % 2 == 0)
			System.out.println(number);
		LinkedList list = next;
		while (list != null) {
			if (list.number % 2 == 0)
				System.out.println(list.number);
			list = list.next;
		}
	}
}
