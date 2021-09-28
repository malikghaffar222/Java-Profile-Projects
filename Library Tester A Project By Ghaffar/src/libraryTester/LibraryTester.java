package libraryTester;

public class LibraryTester {

	public static void main(String[] args) {
		BookShelf shelf1 = new BookShelf();
		shelf1.setBookCharacter('O');

		BookShelf shelf2 = new BookShelf();
		shelf2.setBookCharacter('T');

		System.out.println("BookShelf1: "+shelf1);
		System.out.println("BookShelf2: "+shelf2);
		Book booksArray[] = new Book[4];
		booksArray[0] = new Book("One of a Kind", "Fantasy");
		booksArray[1] = new Book("The Heart of the Betrayed", "Romance");
		booksArray[2] = new Book("The Vision of Roses", "Crime");
		booksArray[3] = new Book("Our Hill of Stars", "Science Fiction");

		for (Book book : booksArray) {
			System.out.println(book);
		}

		for (int i = 0; i < booksArray.length; i++) {
			shelf1.addBook(booksArray[i]);
			shelf2.addBook(booksArray[i]);
		}

		System.out.println("BookShelf1: "+shelf1);
		System.out.println("BookShelf2: "+shelf2);
	}

}
