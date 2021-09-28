import javax.swing.ImageIcon;

public class Node {
	ImageIcon img;
	Node next, prev = this;

	public Node(ImageIcon img) {
		this.img = img;
	}

	public Node(ImageIcon img, Node prev, Node next) {
		this.img = img;
		this.next = next;
		this.prev = prev;
	}
}
