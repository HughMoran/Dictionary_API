package ie.gmit.dip;

import java.util.*;

/**
 * 
 * @author Hugh Moran
 * @version 1.0 
 * 			Wordable Interface contains methods from the WordEntry Class
 */
public interface Wordable {

	// method gets the page number of each word in the book and adds to a List.
	public Set<Integer> getIndices();

	// method get the definition of each word in the book.
	public String getDefinition();

	// method sets the definition of the words in the book.
	public void setDefinition(String definition);

	// method adds the page number to each word in the book.
	public void addIndex(int page);

}
