public class DoublyLinkedList<T> {
  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  // Internal node class to represent data
  private static class Node<T> {
    private T data;
    private Node<T> prev, next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }


  // Return the size of this linked list
  public int size() {
    return size;
  }

  // Is this linked list empty?
  public boolean isEmpty() {
    return size() == 0;
  }

  // Add an element to the tail of the linked list, O(1)
  public void add(T elem) {
    addLast(elem);
  }

  // Add a node to the tail of the linked list, O(1)
  public void addLast(T elem) {
    if (isEmpty()) {
      head = tail = new Node<T>(elem, null, null);
    } else {
      tail.next = new Node<T>(elem, tail, null);
      tail = tail.next;
    }
    size++;
  }
 

  // Check if the list is palindrome
  static Node start;
  public boolean isPalindrome(Node head) {
     
   start = head;
    return rev(head);
}

public boolean rev(Node head) {
    if(head==null)
        return true;
    boolean temp = rev(head.next);
    if(head.data==start.data && temp)
    {
        start = start.next;
        return true;
    }
    else
        return false;
}
    //Print List elements
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
        if(trav.next!=null)
            sb.append(trav.data + ", ");
        else
            sb.append(trav.data);
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }

  public static void main(String[] args) {
      DoublyLinkedList list = new DoublyLinkedList();
      list.add('l');
      list.add('e');
      list.add('v');
      list.add('e');
      list.add('l');
      if(list.isPalindrome(list.head))
        System.out.printf("It is Palindrome");
      else
          System.out.printf("Not Palindrome");

  }
}