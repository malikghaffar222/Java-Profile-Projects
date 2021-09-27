package task4;

public class Digital extends VideoGame {
	private double size;

	public Digital(String name, double price, String studio, double update, double size) {
		super(name, price, studio, update);
		this.size = size;
	}

	public double getSize() {
		return size;
	}

	@Override
	public double calcTotalSize() {
		return size + updateSize;
	}
}
