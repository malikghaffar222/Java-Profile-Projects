import java.util.Arrays;

public class Course {
	String courseName;
	String lecturer;
	Student[] students = new Student[20];
	double malePercentage, femalePercentage;

	private int size = 0;

	public Course(String courseName, String lecturer) {
		this.courseName = courseName;
		this.lecturer = lecturer;
	}

	public boolean addStudent(Student student) {
		if (size == 20) {
			System.out.println("Can't add more than 20 students in a course!");
			return false;
		}
		students[size++] = student;
		if (student.getGender().equals("M"))
			malePercentage++;
		else if (student.getGender().equals("F"))
			femalePercentage++;
		return true;
	}

	public void deleteStudent(String name) {
		boolean moveForward = false;
		for (int i = 0; i < size; i++) {
			if (students[i].getName().equals(name)) {
				moveForward = true;
				size--;
				System.out.println(name + " deleted from course");
			}
			if (moveForward) {
				if (i == size - 1) {
					students[i] = null;
					return;
				}
				students[i] = students[i + 1];
			}
		}
		System.out.println("No student with this name.");
	}

	public void search(String name) {
		for (int i = 0; i < size; i++) {
			if (students[i] == null)
				continue;
			if (name.equals(students[i].getName())) {
				System.out.println(students[i]);
				return;
			}
		}
		System.out.println("There's no student with '" + name + "' name!");
	}

	public String getPercentage() {
		String buffer = "Male percentage: " + Math.ceil((malePercentage / size) * 100) + " %";
		buffer += "\nFemale Percentage: " + Math.floor((femalePercentage / size) * 100) + " %";
		return buffer;
	}

	public String courseDetails() {
		return this.toString();
	}

	public String studentDetails() {
		String buf = "";
		for (int i = 0; i < size; i++) {
			if (students[i].getName().length() != 0 && students[i].getAddress().length() != 0
					&& students[i].getDateOfBirth().length() != 0 && students[i].getGender().length() != 0)
				buf += students[i] + "\n";
		}
		return buf += "\n-----------------------------------------------------------";
	}

	@Override
	public String toString() {
		return ("Course Name: " + courseName + "\nLecturer: " + lecturer + "\nTotal students enrolled: " + size + "\n"
				+ getPercentage() + "\n-----------------------------------------------------------");
	}

	public int size() {
		return size;
	}

	public Student getStudent(int i) {
		return students[i];
	}

}
