package task2;

public class University {
	private String name;
	private Student[] students;
	private int nbStudents;

	public University(String name, int size) {
		this.name = name;
		students = new Student[size];
	}

	abstract class Student {
		private int id;
		private String name;
		protected int nbCourses;
		protected Course[] courses;

		public Student(int id, String name, int size) {
			this.id = id;
			this.name = name;
			courses = new Course[size];
		}

		class Course {
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

	class Graduate extends Student {
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

	class UnderGrad extends Student {

		public UnderGrad(int id, String name, int size) {
			super(id, name, size);
		}

		@Override
		public double calcGPA() {
			return getAverage() / 20;
		}

	}

	public int search(Student s) {
		for (int i = 0; i < nbStudents; i++) {
			if (students[i].getId() == s.getId())
				return i;
		}
		return -1;
	}

	public boolean addStudent(Student s) {
		if (nbStudents >= students.length || search(s) != -1)
			return false;
		students[nbStudents++] = s;
		return true;
	}

	private boolean removeStudent(Student s) {
		for (int i = 0; i < nbStudents; i++) {
			if (students[i].getId() == s.getId()) {
				students[i] = students[--nbStudents];
				students[nbStudents] = null;
				return true;
			}
		}
		return false; // not found
	}

	public Student getMaxGPA() {
		if (nbStudents == 0)
			return null;
		Student maxStudent = students[0];
		for (int i = 1; i < nbStudents; i++) {
			if (students[i].calcGPA() > maxStudent.calcGPA()) {
				maxStudent = students[i];
			}
		}
		return maxStudent;
	}

	public int getNumberOfGrad() {
		if (nbStudents == 0)
			return 0;
		int number = 0;
		for (int i = 0; i < nbStudents; i++) {
			if (students[i].getClass().equals("Graduate"))
				number++;
		}
		return number;
	}

	public void splitStudents(Graduate[] grad, UnderGrad[] underGrad) {
		if (nbStudents == 0)
			return;
		int j = 0, k = 0;
		for (int i = 0; i < nbStudents; i++) {
			if (students[i].getClass().equals("Graduate"))
				grad[j++] = (Graduate) students[i];
			else if (students[i].getClass().equals("UnderGrad"))
				underGrad[k++] = (UnderGrad) students[i];
		}
	}

	public Student[] getStudents(int hours) {
		if (nbStudents == 0)
			return null;
		Graduate graduates[] = new Graduate[getNumberOfGrad()];
		int j = 0;
		for (int i = 0; i < nbStudents; i++) {
			if (students[i].getClass().equals("Graduate")) {
				Graduate graduate = (Graduate) students[i];
				if (graduate.getResearchHours() > hours)
					graduates[j++] = graduate;
			}
		}
		return graduates;
	}

}
