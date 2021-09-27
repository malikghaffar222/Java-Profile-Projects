
public class Train {
	private int numberOfSeats, numberOfStandingSpots;
	private int seatedPassengers, standingPassengers, declinedPassengers;

	public Train(int numberOfSeats, int numberOfStandingSpots) {
		this.numberOfSeats = numberOfSeats;
		this.numberOfStandingSpots = numberOfStandingSpots;
	}

	public void stopAtStation(int numberOfBoardingPassengers, int numberOfAlightingPassengers) {
		/*
		 * if no of leaving passengers is less than or equal to the total passengers i.e
		 * seated+standing
		 */
		if (numberOfAlightingPassengers <= (seatedPassengers + standingPassengers)) {
			// subtract no of leaving passengers from standing passengers
			standingPassengers -= numberOfAlightingPassengers;
			/*
			 * if result is negative that means no of passengers leaving is greater than
			 * standing // passengers hence we will subtract the result(no of remaining
			 * passengers) from // seated passengers and then we make standing passengers to
			 * zero as all // standing passengers have left the train
			 */
			if (standingPassengers < 0) {
				seatedPassengers -= (-standingPassengers);
				standingPassengers = 0;
			}
		}
		/*
		 * alighting is done up till here now boarding
		 * 
		 * if there are empty seats then passenger gets seat
		 */
		int remainingSeats = numberOfSeats - seatedPassengers;
		if (numberOfBoardingPassengers >= remainingSeats) {
			seatedPassengers += remainingSeats;
			numberOfBoardingPassengers -= remainingSeats; // as these number of seats are occupied now
		} else {
			seatedPassengers += numberOfBoardingPassengers;
			numberOfBoardingPassengers = 0;
		}
		// if still there are passengers then they have chance to stand in train
		if (numberOfBoardingPassengers > 0) {
			/*
			 * if there is no more empty seat but there is standing spots then passengers
			 * stand
			 */
			int remainingSpots = numberOfStandingSpots - standingPassengers;
			if (numberOfBoardingPassengers >= remainingSpots) {
				standingPassengers += remainingSpots;
				numberOfBoardingPassengers -= remainingSpots;// as these number of spots are occupied now
			} else {
				standingPassengers += numberOfBoardingPassengers;
				numberOfBoardingPassengers = 0;
			}
		}
		/*
		 * if there is no any empty seat as well as standing spot then decline remining
		 * passengers
		 */
		if (numberOfBoardingPassengers > 0) {
			declinedPassengers += numberOfBoardingPassengers;
		}

	}

	public int getNumberOfSeatedPassengers() {
		return seatedPassengers;
	}

	public int getNumberOfStandingPassengers() {
		return standingPassengers;
	}

	public int getNumberOfDeclinedPassengers() {
		return declinedPassengers;
	}

	public boolean isFull() {
		if ((numberOfSeats + numberOfStandingSpots) == (seatedPassengers + standingPassengers))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Train train = new Train(150, 100);
		train.stopAtStation(100, 0);
		train.stopAtStation(75, 10);
		System.out.println("After two stops:");

		System.out.println(train.getNumberOfSeatedPassengers());
		System.out.println(train.getNumberOfStandingPassengers());

		train.stopAtStation(100, 0);
		train.stopAtStation(100, 10);
		System.out.println("After four stops:");

		System.out.println(train.isFull());
		System.out.println(train.getNumberOfSeatedPassengers());
		System.out.println(train.getNumberOfStandingPassengers());
		System.out.println(train.getNumberOfDeclinedPassengers());

		train.stopAtStation(10, 50);

		System.out.println("After five stops:");
		System.out.println(train.isFull());
		System.out.println(train.getNumberOfSeatedPassengers());
		System.out.println(train.getNumberOfStandingPassengers());
		System.out.println(train.getNumberOfDeclinedPassengers());

	}
}
