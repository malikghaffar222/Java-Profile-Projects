import java.util.ArrayList;

public class City {
	String name;
	ArrayList<Person> population=new ArrayList<>();
	int foundationYear;

	public City(String name, int foundationYear) {
		this.name = name;
		this.foundationYear = foundationYear;
	}

	public City() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(int foundationYear) {
		this.foundationYear = foundationYear;
	}

	public int calculatePopulation() {
		return population.size();
	}

	public void addResident(Person person) {
		population.add(person);
	}
}
