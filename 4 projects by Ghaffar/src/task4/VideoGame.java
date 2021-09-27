package task4;

public abstract class VideoGame {
	private String name;
	private double price;
	private String studio;
	protected double updateSize;

	public double getPrice() {
		if (price < 0)
			throw new IllegalArgumentException();
		return price;
	}

	public String getStudio() {
		return studio;
	}

	public abstract double calcTotalSize();

	VideoGame(String name, double price, String studio, double update) {
		this.name = name;
		this.price = price;
		this.studio = studio;
		this.updateSize = update;
	}

}
