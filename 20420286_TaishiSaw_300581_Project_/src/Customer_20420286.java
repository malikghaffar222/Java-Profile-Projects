
/**
 * @author
 *
 */
class Customer_20420286 {
	int ID;
	String surname;
	String firstName;
	String streetAddress;
	String suburb;
	String postcode;
	String phoneNumber;

	public Customer_20420286() {
	}

	public Customer_20420286(int iD, String surname, String firstName, String streetAddress, String suburb,
			String postcode, String phoneNumber) {
		ID = iD;
		this.surname = surname;
		this.firstName = firstName;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.phoneNumber = phoneNumber;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {

		return "Customer ID: " + ID + "\nSurname: " + surname + "\nCustomer Name: " + firstName + "\nPhone#: "
				+ phoneNumber + "\nStreet Address: " + streetAddress + "\nSuburb: " + suburb + "\nPostcode: " + postcode
				+ "\n\n";
	}

	public String customerOnSingleLine() {
		return ID + "\t" + surname + "\t" + firstName + "\t" + phoneNumber + "\t" + streetAddress + "\t" + suburb + "\t"
				+ postcode + "\n";
	}

}
