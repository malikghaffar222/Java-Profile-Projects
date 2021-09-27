package task2;

public class Graduate extends Student {
	private int researchHours;

	public int getResearchHours() {
		return researchHours;
	}

	public Graduate(int id, String name, int size, int researchHours) {
		super(id, name, size);
		this.researchHours = researchHours;
	}

	@Override
	public String toString() {
		return super.toString() + ",Research hours completed: " + researchHours;
	}

	@Override
	public double calcGPA() {

		return (getAverage() / 25) + (researchHours * 0.05);
	}
}
