package task2;

public class UnderGrad extends Student {

	public UnderGrad(int id, String name, int size) {
		super(id, name, size);
	}

	@Override
	public double calcGPA() {
		return getAverage() / 20;
	}

}
