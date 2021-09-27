public class Student {
	String name = "";
	String dateOfBirth = "";
	String address = "";
	String gender = "";

	public Student(String name, String dateOfBirth, String address, String gender) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Students's Name: " + name + "\nDOB: " + dateOfBirth + "\nAddress: " + address + "\nGender: " + gender;
	}

}
