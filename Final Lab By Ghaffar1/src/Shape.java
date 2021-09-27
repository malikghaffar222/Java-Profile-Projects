
public abstract class Shape {
	String color;

	public Shape(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return color;
	}

	public abstract double getArea();
}
