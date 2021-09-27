public class Train implements Comparable<Train> {
	String company; // variable for holding company name
	int noOfCars; // variable for holding number of cars
	Type type; // type as enumeration
	static int noOfObjects; // variable for holding total number of objects created

	// no argument constructor
	public Train() {
		noOfObjects++; // increment the noOfObject by 1
	}

	// two argument constructor to initialize member variables
	public Train(String company, int noOfCars, Type type) {
		this.company = company;
		this.noOfCars = noOfCars;
		this.type = type;
		noOfObjects++;// increment the noOfObject by 1
	}

	// method that returns total number of objects created
	public static int getNoOfObjects() {
		return noOfObjects;
	}

	// method that returns this Train object as a String
	@Override
	public String toString() {
		return "Company: " + company + "\nNumber of cars: " + noOfCars + "\nType: " + type;
	}

	// method to compare two Train objects on the basis of number of cars
	@Override
	public int compareTo(Train train) {
		if (noOfCars > train.noOfCars)
			return 1;
		if (noOfCars < train.noOfCars)
			return -1;
		return 0;
	}
}
