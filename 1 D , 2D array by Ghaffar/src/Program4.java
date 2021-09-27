import java.util.Scanner;

public class Program4 {

	public static double area(int n, double r) {
		double area = 0.5 * n * Math.pow(r, 2) * Math.sin((2 * Math.PI) / n);
		return Math.ceil(area);
	}

	public static double circumference(int n, double r) {
		double circm = 2 * n * r * Math.sin(Math.PI / n);
		return Math.ceil(circm);
	}

	public static void main(String[] args) {
		int n;
		double r;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of sides: ");
		n = in.nextInt();
		System.out.println("Enter radius: ");
		r = in.nextDouble();

		System.out.println("Area is: " + area(n, r));
		System.out.println("Circumference is: " + circumference(n, r));
	}

}
