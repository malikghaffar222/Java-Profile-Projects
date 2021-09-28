public class Student {
	private String firstName, LastName;
	private double testScore, testPercentage;

	public Student(String firstName, String lastName, double testScore) {
		this.firstName = firstName;
		LastName = lastName;
		this.testScore = testScore;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public double getTestScore() {
		return testScore;
	}

	public double getTestPercentage() {
		return testPercentage;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}

	public void setTestPercentage(double testPercentage) {
		this.testPercentage = testPercentage;
	}

	public double calculatePercentage(double totalPossiblePoints) {
		return (testScore / totalPossiblePoints) * 100;
	}

	public char calculateLetterGrade() {

		if (testPercentage >= 70 && testPercentage < 80)
			return 'C';
		if (testPercentage >= 80 && testPercentage < 90)
			return 'B';
		if (testPercentage >= 90 && testPercentage < 100)
			return 'A';
		else
			return 'F'; // fail
	}
}
