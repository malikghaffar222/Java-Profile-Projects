package task2;

public abstract class Student {
	private int id;
	private String name;
	protected int nbCourses;
	protected Course[] courses;

	public Student(int id, String name, int size) {
		this.id = id;
		this.name = name;
		courses = new Course[size];
	}

	public boolean addCourse(Course c) {
		if (nbCourses >= courses.length)
			return false;
		courses[nbCourses++] = c;
		return true;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAverage() {
		if (nbCourses == 0)
			return 0;
		double avgGrade = 0;
		for (int i = 0; i < nbCourses; i++) {
			avgGrade += courses[i].getGrade();
		}
		return avgGrade;
	}

	public abstract double calcGPA();

	@Override
	public String toString() {
		return "ID: " + id + ",Name: " + name;
	}

}
