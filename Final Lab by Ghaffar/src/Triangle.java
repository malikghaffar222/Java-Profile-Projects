
public class Triangle extends Shape {
	private int base;
	private int height;

	public Triangle(String color, int base, int height) {
		super(color);
		this.base = base;
		this.height = height;
	}

	@Override
	public double doubleGetArea() {
		return (0.5 * base * height);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
