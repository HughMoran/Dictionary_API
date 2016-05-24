package ie.gmit.dip;

import java.util.*;

/**
 * @author Hugh Moran
 * @version 1.0 SearchMenu contains the methods that create a user interface and
 *          allow for the user to choose a book to index.
 */
public class SearchMenu {
	// private variables
	private String menuText;
	private GetOtherBook t = new GetOtherBook();
	private BookParser bP = new BookParser();
	private Scanner s = new Scanner(System.in);
	private boolean keepRunning = true;

	/**
	 * Constructor for: SearchMenu, buildMenu and getOption allows the menu to
	 * be built
	 */

	public SearchMenu() {
		super();
		this.buildMenu();// constructor

		System.out.println(menuText);
		this.getOption();
	}

	/**
	 * Method gets the user input and passes the name of the book to the
	 * bookParser method for it to be indexed.
	 */
	private void getOption() {
		// if else loops uses the user input to pass the choice of book
		int option = s.nextInt();
		if (option == 1) {
			bP.bookParser("parseFiles/HappyPrince-Wilde.txt");
			// secondOption();
		} else if (option == 2) {
			bP.bookParser("parseFiles/DivineComedy-Dante.txt");
		} else if (option == 3) {
			bP.bookParser("parseFiles/PictureOfDorianGray-Wilde.txt");
		} else if (option == 4) {
			bP.bookParser("parseFiles/ThePrince-Machiavelli.txt.txt");
		} else if (option == 5) {
			bP.bookParser("parseFiles/WarAndPeace-Tolstoy.txt");
		} else if (option == 6) {
			bP.bookParser("parseFiles/PoblachtNaHEireann.txt");
		} else if (option == 7) {
			System.out.println("Enter File Path of Book: ");
			t.otherBook();
		} else if (option == 8) {
			System.out.println("Bye!");
			keepRunning = false;
		}
		// SearchMenu m = new SearchMenu();
	}

	/**
	 * @buildMenu Uses a StringBuffer to append each line of the user GUI to a
	 *            buildMenu String allow it to be printed out in the SearchMenu
	 *            method
	 */
	private void buildMenu() {
		// StringBuffer appends the text to the Buffer where it is later added
		// to the menuText String
		StringBuffer sb = new StringBuffer();// A Local Variable
		sb.append("------------------------------------------\n");// append add
		sb.append("\t Diction Builder API 1.0\n");
		sb.append("------------------------------------------\n");
		sb.append("Choose one of the following Books:\n");
		sb.append("Option 1: Happy Prince\n");
		sb.append("Option 2: Divine Comedy\n");
		sb.append("Option 3: Picture Of Dorian Gray\n");
		sb.append("Option 4: The Prince\n");
		sb.append("Option 5: War and Peace\n");
		sb.append("Option 6: Poblacht Na HEireann\n");
		sb.append("Option 7: Enter File Path of Book:\n");
		sb.append("8. Exit\n");
		sb.append("Enter Option [1-8}>");
		menuText = sb.toString();
	}

}
