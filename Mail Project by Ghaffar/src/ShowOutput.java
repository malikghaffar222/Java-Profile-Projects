import java.util.LinkedList;
import java.util.Queue;

public class ShowOutput {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		// adding new element(s) to queue(Enqueue operation)
		System.out.println(queue.add(5));
		System.out.println(queue.add(3));
		// removing element(s) to queue(Dequeue operation)
		System.out.println(queue.remove());
		System.out.println(queue.add(2));
		System.out.println(queue.add(8));
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.add(9));
		System.out.println(queue.add(1));
		System.out.println(queue.remove());
		System.out.println(queue.add(7));
		System.out.println(queue.add(6));
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.add(4));
		System.out.println(queue.remove());
		System.out.println(queue.remove());

	}

}
