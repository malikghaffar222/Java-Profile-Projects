
public class Node {
	int ticketID;
	int paxID;
	int journeyDate;
	int srcModule;
	int destModule;
	String paxName;
	Node next;

	public Node(int ticketID, int paxID, int journeyDate, int srcModule, int destModule, String paxName) {
		this.ticketID = ticketID;
		this.paxID = paxID;
		this.journeyDate = journeyDate;
		this.srcModule = srcModule;
		this.destModule = destModule;
		this.paxName = paxName;
	}

	public Node() {
	}

	@Override
	public String toString() {
		return ticketID + "    " + paxID + "    " + journeyDate + "    " + srcModule + "    " + destModule + "    "
				+ paxName;
	}
}
