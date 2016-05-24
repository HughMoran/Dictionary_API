package ie.gmit.dip;

import java.io.*;
import java.util.*;

/**
 * @author Hugh Moran
 * @version 1.0 
 * 			StopParser class reads in the stop words text file and stores
 *          them to the TreeSet.
 */
public class StopParser {
	// stopword file is constant so its static final
	private static final String STOP_FILE = "parseFiles/stopwords.txt";
	public static Collection<String> stop = new TreeSet<String>();

	/**
	 * @return stop 
	 * 			stopParser method reads in the stopwords.txt file using a
	 *          BufferedReader
	 */
	public Collection<String> stopParser() {
		// BufferedReader efficient for reading in files line by line
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(STOP_FILE)));
			String line;
			while ((line = br.readLine()) != null) {
				// splits line by spaces and adds them to the words array at
				// each index
				String[] words = line.split(" ");
				for (String word : words) {
					// adds the stop words to the TreeSet and sets them to
					// lowercase so that
					// they will match the words in the book that will be set to
					// lowercase also
					stop.add(word.toLowerCase());
				}

			}
			/*
			 * Used to test if the file was read in... 
			 * Iterator<String> iterator = stop.iterator();
			 * while(iterator.hasNext()) {
			 * System.out.println(iterator.next()); 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returns the stop words to the class so that it can be read to the
		// BookParser class
		return stop;

	}

}
