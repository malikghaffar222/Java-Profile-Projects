
public class Person {
	protected String name;
	protected boolean male;
	protected String id;
	protected Person spouse;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person(String name, String id, boolean isMale) {
		this.name = name;
		this.id = id;
		this.male = isMale;
	}

	public void displayInfo() {
		System.out.println("Name: " + getName());
		System.out.println("ID: " + getId());
		if (male)
			System.out.println("Gender is Male");
		else
			System.out.println("Gender is Female");
		if (spouse != null) {
			System.out.println("Married with.........");
			System.out.println("Name: " + spouse.getName());
			System.out.println("ID: " + spouse.getId());
		} else {
			System.out.println("Unmarried......");
		}
	}

	public static void main(String[] args) {
		Person ahmad = new Person("Ahmad", "XD301", true);
		Person mona = new Person("Mona", "ME101", false);
		ahmad.setSpouse(mona);
		mona.setSpouse(ahmad);

		Person thirdPerson = new Person("Ali", "GR703", true);
		
		ahmad.displayInfo();
		System.out.println("........................");
		mona.displayInfo();
		System.out.println("........................");
		thirdPerson.displayInfo();
	}
}
