package task3;

public class LinkedListOfEmployees {
	Node head;

	public LinkedListOfEmployees() {
	}
	
	class Node {

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


	public void insertAtEnd(Employee e) {
		if (head == null)
			head = new Node(e);
		Node p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(new Node(e));
	}

	public void insertAtFront(Employee e) {
		Node temp = head;
		head = new Node(e);
		head.setNext(temp);
	}

	public int countEmployees(String g) {
		if (head == null)
			return 0;
		Node p = head;
		int count = 0;
		while (p != null) {
			if (p.getData().getGender().equalsIgnoreCase(g))
				count++;
			p = p.getNext();
		}
		return count;
	}

	public Employee getOldestEmployee() {
		if (head == null)
			return null;
		Node p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		return p.getData();
	}

	public LinkedListOfEmployees getEmployees(String g) {
		if (head == null)
			return null;
		LinkedListOfEmployees list = new LinkedListOfEmployees();
		Node p = head;
		int count = 0;
		while (p != null) {
			if (p.getData().getGender().equalsIgnoreCase(g))
				list.insertAtFront(p.getData());
			p = p.getNext();
		}
		return list;
	}

	public void splitEmployees(LinkedListOfEmployees male, LinkedListOfEmployees female) {
		if (head == null)
			return;
		Node p = head;
		int count = 0;
		while (p != null) {
			if (p.getData().getGender().equalsIgnoreCase(("male")))
				male.insertAtFront(p.getData());
			else if (p.getData().getGender().equalsIgnoreCase(("female")))
				female.insertAtFront(p.getData());
			p = p.getNext();
		}
	}

	public void display() {
		if (head == null)
			return;
		Node p = head;
		while (p != null) {
			p.getData().displayEmployeeInfo();
			System.out.println();
			p = p.getNext();
		}
	}
}
