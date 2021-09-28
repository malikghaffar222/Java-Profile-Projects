import javax.swing.ImageIcon;

public class MyImageQueue {
	private int size;
	private Node head = new Node(null);

	public void add(ImageIcon img) {
		head.prev = head.prev.next = new Node(img, head.prev, head.next);
		size++;
	}

	public ImageIcon first() {
		return head.next.img;
	}

	public ImageIcon remove() {
		ImageIcon img = head.next.img;
		head.next = head.next.next;
		head.next.prev = head;
		size--;
		return img;
	}

	public int size() {
		return size;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public Node getHead() {
		return head;
	}
}
