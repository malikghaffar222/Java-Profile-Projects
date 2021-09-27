import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityTest {
	private ArrayList<Person> population;

	@BeforeEach
	void setUp() throws Exception {
		population = new ArrayList<>();
	}

	@Test
	public void getName() {
		City c = new City("ABC", 123);
		assertEquals("ABC", c.getName());
	}

	@Test
	public void setName(String name) {
		City c = new City("ABC", 123);
		this.setName(name);
	}

	@Test
	public void getFoundationYear() {
		City c = new City("ABC", 123);
		assertEquals(123, c.getFoundationYear());
	}

	@Test
	public void setFoundationYear(int foundationYear) {
		City c = new City("ABC", 123);
		c.setFoundationYear(foundationYear);
	}

	@Test
	public void calculatePopulation() {
		City c = new City("ABC", 123);
		assertEquals(1, c.getFoundationYear());
	}

	@Test
	public void addResident(Person person) {
		population.add(person);
	}

}
