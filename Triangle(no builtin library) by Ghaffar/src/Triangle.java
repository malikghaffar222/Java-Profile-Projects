public class Triangle {
	Integer e1, e2, e3;

	Triangle() {
		e1 = e2 = e3 = 1;
	}

	public Triangle(Integer e1, Integer e2, Integer e3) {
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}

	public boolean isValid() {
		if (e1 > 0 && e2 > 0 && e3 > 0) {
			if (e1 + e2 > e3)
				return true;
			return false;
		}
		return false;
	}

	public void sortEdge() {
		int arr[] = { e1, e2, e3 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		e1 = arr[0];
		e2 = arr[1];
		e3 = arr[2];
	}

	public int max() {
		int arr[] = { e1, e2, e3 };
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;

	}

	public int medium() {
		int arr[] = { e1, e2, e3 };
		int medium = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] > medium && arr[i] < max())
				medium = arr[i];
		return medium;
	}

	public int min() {
		int arr[] = { e1, e2, e3 };
		int min = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	public Integer getPerimeter() {
		return e1 + e2 + e3;
	}

	public boolean isRightTriangle() {
		return (max() * max() == min() * min() + medium() * medium());
	}

	public boolean isIsosceles() {
		return (e1 == e2 || e1 == e3 || e2 == e3);
	}

	public boolean isEquilateral() {
		return (e1 == e2 && e2 == e3);
	}

	public boolean isObtuse() {
		return (max() * max() > min() * min() + medium() * medium());
	}

	public boolean isSimilar(Triangle triangle) {
		double a1 = e1, b1 = e2, c1 = e3;
		double a2 = triangle.e1, b2 = triangle.e2, c2 = triangle.e3;

		return (a1 / a2 == b1 / b2 && b1 / b2 == c1 / c2);

	}

	public int compareTo(Triangle triangle) {
		if (this.getPerimeter() == triangle.getPerimeter()) {
			if (this.max() == triangle.max())
				return 0;
			if (this.max() > triangle.max())
				return 1;
			if (triangle.max() > this.max())
				return -1;
		} else if (this.getPerimeter() > triangle.getPerimeter())
			return 1;
		return -1; // if (triangle.getPerimeter() > this.getPerimeter())
	}

	public boolean identicalTo(Triangle triangle) {
		triangle.sortEdge();
		this.sortEdge();
		return (this.isSimilar(triangle) && (this.getPerimeter() == triangle.getPerimeter()));
	}

	public int poweredPerimeter(int pow) {
		if (pow < 0)
			return -1;
		if (pow == 0)
			return 1;
		int perimeter = getPerimeter();
		for (int i = 1; i < pow - 1; i++) {
			perimeter *= perimeter;
		}
		return perimeter;
	}

}
