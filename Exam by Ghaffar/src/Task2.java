
public class Task2 {

	public static void main(String[] args) {
		LinkedList list=new LinkedList(234);
		list.insert(475);
		list.insert(333);
		list.insert(186);
		list.insert(277);
		list.insert(542);
		
		System.out.println("All numbers in the list : ");
		list.display();
		System.out.println("All Even numbers in the list :");
		list.displayEvenNumbers();

	}

}
