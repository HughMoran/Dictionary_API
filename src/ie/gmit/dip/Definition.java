package ie.gmit.dip;

/**
 * 
 * @author Hugh Moran
 * @version 1.0 Definition class contains the getters and setters for the
 *          definition of the words in the selected book.
 */

public class Definition {
	private WordEntry we = new WordEntry();
	private String definition;

	/**
	 * @param definition
	 *            Passes the word definition to the constructor
	 */
	public Definition(String definition) {
		// Constructor for the definition class
		super();
		this.definition = definition;
	}

	/**
	 * @return definition Returns the definition to the class so that the word
	 *         defintition can be got from another class
	 */
	public String getDefinition() {
		return we.getDefinition();
	}

	/**
	 * @param definition
	 *            passes the definition so that it can be set to the word with
	 *            its definition
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
}
