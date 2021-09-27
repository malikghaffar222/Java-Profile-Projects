
public class Passenger {
	private int ticketNumber;
	private String name;

	public Passenger(int ticketNumber, String name) {
		this.ticketNumber = ticketNumber;
		this.name = name;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		Passenger anotherPassenger = (Passenger) obj;
		if (this.ticketNumber == anotherPassenger.getTicketNumber())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {

		return name + "(" + ticketNumber + ")";
	}
}
