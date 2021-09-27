import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Assignment4 {
	public static Vector<Integer> MergeVector(Vector<Integer> v1, Vector<Integer> v2) {
		Vector<Integer> newVector = new Vector<Integer>();
		newVector.addAll(v1);
		newVector.addAll(v2);
		System.out.println("First Vector Elements: " + v1);
		System.out.println("Second Vector Elements: " + v2);
		Collections.sort(newVector);
		System.out.println("Merge Vector Elements in sorted Order: " + newVector);
		return newVector;
	}

	public static void main(String[] args) {
		Vector<Integer> v1 = new Vector<>();
		v1.add(5);
		v1.add(6);
		v1.add(7);
		v1.add(8);

		Vector<Integer> v2 = new Vector<>();
		v2.add(1);
		v2.add(2);
		v2.add(3);
		v2.add(4);

		Vector<Integer> mergeVector = MergeVector(v1, v2);
	}
}
