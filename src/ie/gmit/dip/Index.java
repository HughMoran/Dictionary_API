package ie.gmit.dip;

import java.util.Set;
 
/**
 * @author Hugh Moran
 * @version 1.0 
 * 			Index Class contains the getters and setter for adding the page
 *          numbers of the books
 */

public class Index {
	private WordEntry we = new WordEntry();
	private Set<Integer> indices;

	/**
	 * Constructor for the Index Class
	 */
	public Index() {
		super();
	}

	/**
	 * @return indices 
	 * 			indices the variable declaration on the ArrayList returns
	 *          the page number to the class
	 */
	public Set<Integer> getIndices() {
		return we.getIndices();
	}

	/**
	 * @param page
	 *            passes int page to the method so that the page number can be
	 *            added to the indices HashMap
	 */
	public void addIndex(int page) {
		// if loop make sure that there is no chance of a 0 page number to be
		// added to the Map
		if (page != 0) {
			indices.add(page);
		}
	}

}
