/* Developed By: Kevin Wong
 * Revised Date: Apr 05, 2021
 * Version     : Ver 1.1 */

/* NOTE: PROVIDED CLASS. DO NOT CHANGE ANYTHING HERE
 *       OR ELSE THE BOOKSHELF SYSTEM WILL NOT WORK. 
 *       JUST USE IT AS IS */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BookShelfDB {
	public final static int ARRAY_POS_BOOK_TYPE = 0;
	public final static int ARRAY_POS_BOOK_NAME = 1;
	public final static int ARRAY_POS_NUM_PAGE = 2;
	public final static int ARRAY_POS_INFO = 3;

	private Book[] allBooks; // It stores all the Book objects.

	// =============== Constructor =================
	/* Initializes the Book array variable */
	public BookShelfDB() {
		this.allBooks = null;
	}

	// ============ PRIVATE METHOD =========//
	/* To increase the size of the Book object array by 1 element. */
	private void growBookArray() {
		if (allBooks != null) {
			// When there are other rooms in the AllRooms array
			Book[] newArray = new Book[allBooks.length + 1];
			for (int i = 0; i < allBooks.length; i++) {
				// Copy all the elements from the old array to the new array.
				newArray[i] = allBooks[i];
			}
			// Assign the newArray reference back to the old array variable.
			allBooks = newArray;
		} else {
			// When the allRooms array is empty
			allBooks = new Book[1];
		}
	}

	// ============ PUBLIC METHOD =========//
	/*
	 * Generate a random new Book ID. This new Book ID is a new number not found in
	 * the database
	 */
	public int GenNewBookId() {
		int randID;
		boolean isInDB;

		if (allBooks == null) {
			return (int) (Math.random() * ((1999 - 1000) + 1)) + 1000;
		} else {
			do {
				isInDB = false;
				randID = (int) (Math.random() * ((1999 - 1000) + 1)) + 1000;
				for (int i = 0; i < allBooks.length; i++) {
					if (allBooks[i].GetBookId() == randID) {
						isInDB = true;
						break;
					}
				}
			} while (isInDB);

			return randID;
		}
	}

	/*
	 * Add multiple Books into the database (array) from a text file.
	 * 
	 * @param filename - The filename of the file, including the file extension.
	 * (Note: text file must be stored in the same folder as the program)
	 * 
	 * @param startRoomId - The unused new Book ID for the new Books. The method
	 * will automatically assign the next Room in ascending order. (If startBookId =
	 * 100001, then NewBook1.bookId = (100001 + 0), NewBook2.bookId = (100001 + 1),
	 * ... ,NewBookN.bookId = (100001 + N-1) )
	 * 
	 * @return - Number of books it has imported into the database.
	 */
	public int AddBook(String filename) {
		int numImported = 0;
		try {
			Scanner input = new Scanner(new File(filename));

			// While the file has a line of record
			while (input.hasNextLine()) {
				// Look for the account number
				String bookInfo = input.nextLine();
				String[] arrayData = bookInfo.split(":");

				if (arrayData[0].equals("")) {
					break;
				}

				// Determine the room type and create the appropriate
				// room object for it.
				Book newBook = null;
				int newBookId = this.GenNewBookId();
				int bookType = Integer.parseInt(arrayData[ARRAY_POS_BOOK_TYPE]);
				switch (bookType) {
				case Book.HISTORY:
					newBook = new History(newBookId, arrayData[ARRAY_POS_BOOK_NAME],
							Integer.parseInt(arrayData[ARRAY_POS_NUM_PAGE]), arrayData[ARRAY_POS_INFO]);
					break;
				case Book.NON_FICTION:
					newBook = new NonFiction(newBookId, arrayData[ARRAY_POS_BOOK_NAME],
							Integer.parseInt(arrayData[ARRAY_POS_NUM_PAGE]), arrayData[ARRAY_POS_INFO]);
					break;
				case Book.NOVEL:
					newBook = new Novel(newBookId, arrayData[ARRAY_POS_BOOK_NAME],
							Integer.parseInt(arrayData[ARRAY_POS_NUM_PAGE]),
							Boolean.parseBoolean(arrayData[ARRAY_POS_INFO]));
					break;
				default:
				}

				// Only add a room when the room is valid
				boolean status = this.AddBook(newBook);

				if (status) {
					// Keep track of the number of rooms imported.
					// startBookId++;
					numImported++;
				} else {
					// Unable to add room
				}
			}

			input.close();
		} catch (IOException ex) {
			System.out.println("General I/O exception: " + ex.getMessage());
			numImported = 0;
		}

		return numImported;
	}

	/*
	 * Add a Book object into the database array
	 * 
	 * @param room - The Book object to be added into the database array
	 * 
	 * @return - True if successfully added the Book object False otherwise.
	 */
	public boolean AddBook(Book newBook) {
		if (newBook != null) {
			this.growBookArray();
			this.allBooks[allBooks.length - 1] = newBook;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Get the number of books that are in the bookshelf
	 * 
	 * @return - Number of books the bookshelf (The bookShelf object) has
	 */
	public int NumBooks() {
		if (this.allBooks == null) {
			return 0;
		} else {
			return this.allBooks.length;
		}
	}

	/*
	 * Get a specific Book object at the position in the array. It acts like a
	 * regular array, where the first Book added is at position 0, second Book at
	 * position 1, etc.
	 * 
	 * @param pos - The position in the database array.
	 * 
	 * @return - The Book object that is at position pos
	 */
	public Book GetBookAt(int pos) {
		if (this.allBooks != null && 0 <= pos && pos <= this.allBooks.length - 1) {
			return this.allBooks[pos];
		} else {
			return null;
		}
	}

	/*
	 * Delete a Book object in the database array
	 * 
	 * @param roomId - The Book ID of the book that needs to be deleted
	 * 
	 * @return - True if successfully deleted the Book object False otherwise.
	 */
	public boolean DeleteBook(int bookId) {
		boolean status = false;
		if (allBooks != null) {
			for (int i = 0; i < allBooks.length; i++) {
				if (bookId == allBooks[i].GetBookId()) {
					int newArrayPos = 0;
					Book[] newArray = new Book[allBooks.length - 1];
					for (int j = 0; j < allBooks.length; j++) {
						if (j != i) {
							newArray[newArrayPos] = allBooks[j];
							newArrayPos++;
						}
					}

					allBooks = newArray;
					status = true;
					break;
				}
			}
		}

		return status;
	}
}