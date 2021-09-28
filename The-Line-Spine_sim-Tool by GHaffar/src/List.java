
public class List {
	Node Head;
	int size;

	public List() {
	}

	public void insert(Node N) {
		if (Head == null)
			Head = N;
		else {
			Node p = Head;
			while (p.next != null) {
				if (isGreater(p.next.journeyDate, N.journeyDate))
					break;
				p = p.next;
			}
			Node temp = p.next;
			p.next = N;
			N.next = temp;
		}
		size++;
	}

	public void remove(int PaxID) {
		if (Head == null)
			return;
		if (Head.paxID == PaxID) {
			Head = Head.next;
			return;
		}
		Node p = Head;
		while (p.next != null) {
			if (p.next.paxID == PaxID) {
				p.next = p.next.next;
				return;
			}
			p = p.next;
		}
		System.out.println("\nNo any Passenger with this PaxID!\n");
	}

	public int cost(int PaxID) {
		if (Head == null)
			return -1;
		Node p = Head;
		int journeyCost = 0;
		while (p != null) {
			if (p.paxID == PaxID)
				journeyCost += (Math.abs(p.srcModule - p.destModule) * 5);
			p = p.next;
		}
		return journeyCost;
	}

	public void print1(int PaxID) {
		if (Head == null)
			return;
		Node p = Head;
		while (p != null) {
			if (p.paxID == PaxID)
				System.out.println(p.toString());
			p = p.next;
		}
	}

	public void print2(int journeyDate) {
		if (Head == null)
			return;
		Node p = Head;
		while (p != null) {
			if (p.journeyDate == journeyDate)
				System.out.println(p.toString());
			p = p.next;
		}
	}

	public void print3(int srcModule) {
		if (Head == null)
			return;
		Node p = Head;
		while (p != null) {
			if (p.srcModule == srcModule)
				System.out.println(p.toString());
			p = p.next;
		}
	}

	public void print4(int destModule) {
		if (Head == null)
			return;
		Node p = Head;
		while (p != null) {
			if (p.destModule == destModule)
				System.out.println(p.toString());
			p = p.next;
		}
	}

	//method to insert nodes wrt dates in order
	private boolean isGreater(int d1, int d2) {
		String s1 = d1 + "";
		String s2 = d2 + "";
		if (s1.substring(s1.length() - 4).compareTo(s2.substring(s2.length() - 4)) > 0)
			return true;

		else if (s2.substring(s2.length() - 4).compareTo(s1.substring(s1.length() - 4)) > 0)
			return false;

		if (s1.substring(s1.length() - 6, s1.length() - 4)
				.compareTo(s2.substring(s2.length() - 6, s2.length() - 4)) > 0)
			return true;

		else if (s2.substring(s2.length() - 6, s2.length() - 4)
				.compareTo(s1.substring(s1.length() - 6, s1.length() - 4)) > 0)
			return false;

		if (s1.substring(0, s1.length() - 6).compareTo(s2.substring(0, s2.length() - 6)) > 0)
			return true;

		else if (s2.substring(0, s2.length() - 6).compareTo(s1.substring(0, s1.length() - 6)) > 0)
			return false;

		return true;
	}
}
