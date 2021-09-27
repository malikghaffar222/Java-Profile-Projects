import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PassengerTrain {
	private int numberOfSeats, numberOfStandingSpots;
	private List<Passenger> seatedPassengers=new ArrayList<>(), standingPassengers=new ArrayList<>(), declinedPassengers=new ArrayList<>();

	public PassengerTrain(int numberOfSeats, int numberOfStandingSpots) {
		this.numberOfSeats = numberOfSeats;
		this.numberOfStandingSpots = numberOfStandingSpots;
	}

	public void stopAtStation(List<Passenger> boardingPassengers, List<Passenger> alightingPassengers) {
		/*
		 * if no of leaving passengers is less than or equal to the total passengers i.e
		 * seated+standing
		 */
		if (alightingPassengers.size() != 0)
			if (alightingPassengers.size() <= (seatedPassengers.size() + standingPassengers.size())) {
				// remove the leaving passengers from seated/standing passengers's list wherever
				// they exist
				for (int i = 0; i < alightingPassengers.size(); i++) {
					seatedPassengers.removeAll(alightingPassengers);
					standingPassengers.removeAll(alightingPassengers);
				}
			}
		/*
		 * alighting is done up till here now boarding
		 * 
		 * if there are empty seats then passenger gets seat
		 */
		
		
		int remainingSeats = numberOfSeats - seatedPassengers.size();
		if (boardingPassengers.size() >= remainingSeats) {
			for (int i = 0; i < remainingSeats; i++) {
				seatedPassengers.add(boardingPassengers.remove(0));// every time the next element is at index zero
			}
		} else {
			for (int i = 0; i < boardingPassengers.size(); i++)
				seatedPassengers.add(boardingPassengers.get(i));
			boardingPassengers.removeAll(boardingPassengers); // removing its all elements
		}
		// if still there are passengers then they have chance to stand in train
		if (boardingPassengers.size() > 0) {
			/*
			 * if there is no more empty seat but there is standing spots then passengers
			 * stand
			 */
			int remainingSpots = numberOfStandingSpots - standingPassengers.size();
			if (boardingPassengers.size() >= remainingSpots) {
				for (int i = 0; i < remainingSpots; i++) {
					standingPassengers.add(boardingPassengers.remove(0));// every time the next element is at index zero
				}
			} else {
				for (int i = 0; i < boardingPassengers.size(); i++)
					standingPassengers.add(boardingPassengers.get(i));
				boardingPassengers.removeAll(boardingPassengers); // removing its all elements
			}
		}
		/*
		 * if there is no any empty seat as well as standing spot then decline remining
		 * passengers
		 */
		if (boardingPassengers.size() > 0) {
			declinedPassengers.addAll(boardingPassengers);
		}
	}

	public List<Passenger> getSeatedPassengers() {
		return seatedPassengers;
	}

	public List<Passenger> getStandingPassengers() {
		return standingPassengers;
	}

	public boolean isFull() {
		if ((numberOfSeats + numberOfStandingSpots) == (seatedPassengers.size() + standingPassengers.size()))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		PassengerTrain train = new PassengerTrain(2, 1);
		Passenger john = new Passenger(1152, "John");
		Passenger jane = new Passenger(1185, "Jane");
		List<Passenger> list = new ArrayList<>();
		list.add(john);
		list.add(jane);
		train.stopAtStation(list, new ArrayList<>());
		System.out.println("After first stop:");
		System.out.println(train.getSeatedPassengers());
		System.out.println(train.getStandingPassengers());
		
		Passenger julia = new Passenger(1197, "Julia");
		//list.clear();
		list.add(julia);

		train.stopAtStation(list, new ArrayList<>());
		System.out.println("After second stop:");
		System.out.println(train.getSeatedPassengers());
		System.out.println(train.getStandingPassengers());

		list.add(jane);
		list.add(julia);

		train.stopAtStation(new ArrayList<>(), list);
		System.out.println("After third stop:");
		System.out.println(train.getSeatedPassengers());
		System.out.println(train.getStandingPassengers());

	}
}
