package ie.gmit.dip;

import java.io.*;
import java.util.*;

/**
 * @author Hugh Moran
 * @version 1.0
 * 
 *          Dictionary parser reads the dictionary.csv file in to a HashMap and
 *          stores the the first index as the key and the other 3 indexes as the
 *          value.
 */

public class DictionaryParse {
	public static final String DICTIONARY_FILE = "parseFiles/dictionary.csv";
	public static Map<String, String> dictionary = new HashMap<String, String>();

	/**
	 * @return the dictionary HashMap to the class, The Method reads in the 
	 *         dictionary.csv file with a BufferedReader
	 */
	public Map<String, String> dictionaryParse() {

		try {
			// Buffered reader to read line by line along with the a
			// InputStreamReader and
			// FileInputStream as it is more effecient to read the file in...
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(DICTIONARY_FILE)));
			// StringBuffer sb = new StringBuffer();
			String line;
			String type;
			String definition;
			String key = null;
			String value = null;
			// allows the line to be read one at a time as long as its not at
			// the end of the file...
			while ((line = br.readLine()) != null) {
				// Split the line of text using the split method unfortuneatly
				// was unable to read the complete definition
				String[] arr = line.split(",");
				if (arr.length == 3) {
					key = arr[0];

					/*
					 * for (int i = 1; i < arr.length; i++) { 
					 * sb.append(arr[i]);
					 * 
					 * if (!arr[i].startsWith("\"")) { 
					 * value = sb.toString(); 
					 * }
					 * }
					 */

					type = arr[1];
					definition = arr[2];
					value = key + type + definition;

				}
				// putting the key and values into the map while putting
				// the key to lowercase and trimming any white space of the ends
				dictionary.put(key.toLowerCase().trim(), value);

			}
			// close the buffered reader
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning the value to the class so that it can be used in another
		// method
		return dictionary;
	}
}
