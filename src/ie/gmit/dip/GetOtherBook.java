package ie.gmit.dip;

import java.util.*;

/**
 * @author Hugh Moran
 * @version 1.0 
 * 			To allow for a books file path to be passed to the bookParser
 *          method as the menu would keep cutting out before it allowed the file
 *          path to be passed.
 */

public class GetOtherBook {

	/**
	 *  Allows for a file path to be passed into the bookParser method
	 *  int BookParse class
	 */
	public void otherBook() {
		// Creates the constructor for the BookParser Class
		BookParser bP = new BookParser();
		String book;
		// Scanner to allow for user input
		Scanner s = new Scanner(System.in);

		// System.out.println("Enter File Path: ");

		// passes book to the bookParser method in BookParser
		book = s.nextLine();
		bP.bookParser(book);

	}
}