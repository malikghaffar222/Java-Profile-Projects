package task2;

public class Course {
	private String name;
	private double grade;

	public Course(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public double getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return name + ":" + grade;
	}
}
