package task3;

public class Node {

	private Employee data;
	private Node next;

	public Node(Employee e) {
		this.data = e;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
