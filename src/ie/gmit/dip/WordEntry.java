package ie.gmit.dip;

import java.util.*;

/**
 * 
 * @author Hugh Moran
 * @version 1.0 WordEntry class implements the Wordable interface Contains the
 *          getters and setters to get and set the definition and the page
 *          number for each word in the book
 */

public class WordEntry implements Wordable {
	private Set<Integer> indices = new HashSet<Integer>();
	private String definition;

	/**
	 * Constructor for the WordEntry Class not being passed any parameters
	 */
	public WordEntry() {
		super();
	}

	/**
	 * @param definition
	 *            Sets the definition for the word in the text book
	 * @param indices
	 *            Sets the page number for the words in the text book
	 */
	public WordEntry(String definition, Set<Integer> indices) {
		super();
		this.definition = definition;
		this.indices = indices;

	}

	/**
	 * @return this.indices Returns the page number for the words in the text
	 *         book from the ArrayList
	 */
	public Set<Integer> getIndices() {
		return this.indices;
	}

	/**
	 * @param page
	 *            passes the parameter of the page number so that it can be
	 *            added to the indices
	 */
	public void addIndex(int page) {
		// if loop make sure that there is no chance of a 0 page number to be
		// added to the Map
		if (page != 0) {
			indices.add(page);
		}
	}

	/**
	 * @return definition Returns the definition for the words in the text book.
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * @param definition
	 *            Sets the definition for the words in the text file
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

}
