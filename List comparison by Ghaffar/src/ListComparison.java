import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ListComparison {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		final int length = 100000;
		Random random = new Random();
		long startTime, endTime, getTime, arrayInsertTime, listInsertTime;

		// inserting 100000 random elements in ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < length; i++) {
			arrayList.add(random.nextInt());
		}
		endTime = System.nanoTime();
		arrayInsertTime = endTime - startTime;

		// inserting 100000 random elements in ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < length; i++) {
			linkedList.add(random.nextInt());
		}
		endTime = System.nanoTime();
		listInsertTime = endTime - startTime;

		// getting elements from ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < args.length; i++) {
			arrayList.get(random.nextInt(100000));
		}
		endTime = System.nanoTime();
		getTime = endTime - startTime;
		// get time of ArrayList
		System.out.println("Time for get in ArrayList(ns): " + getTime);

		// getting elements from LinkedList
		startTime = System.nanoTime();
		for (int i = 0; i < args.length; i++) {
			linkedList.get(random.nextInt(100000));
		}
		endTime = System.nanoTime();
		getTime = endTime - startTime;
		// get time of LinkedList
		System.out.println("Time for get in LinkedList(ns): " + getTime);
		// insert time of ArrayList
		System.out.println("Time for insertion in ArrayList(ns): " + arrayInsertTime);
		// insert time of LinkedList
		System.out.println("Time for insertion in LinkedList(ns): " + listInsertTime);

	}

}
