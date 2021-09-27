package task4;

public class Physical extends VideoGame {
	private String condition;

	Physical(String name, double price, String studio, double update, String con) {
		super(name, price, studio, update);
		this.condition = con;
	}

	public String getCondition() {
		return condition;
	}

	@Override
	public double calcTotalSize() {
		return updateSize;
	}
}
