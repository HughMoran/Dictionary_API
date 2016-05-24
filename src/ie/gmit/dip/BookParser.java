package ie.gmit.dip;

import java.io.*;
import java.util.*;

/**
 * @author Hugh Moran
 * @version 1.0
 * 
 *          BookParser Class used to read in the .txt file so that the the new
 *          Index dictionary can be built on the fly. The Class also contains
 *          methods searchWord() and downloadFile(), each used to preform
 *          seperate tasks.
 */

public class BookParser extends WordEntry {

	WordEntry we = new WordEntry();
	Scanner s = new Scanner(System.in);
	DictionaryParse dp1 = new DictionaryParse();
	Map<String, String> dictionary = dp1.dictionaryParse();

	StopParser st1 = new StopParser();
	Collection<String> stop = st1.stopParser();

	Map<String, WordEntry> wordIndex = new HashMap<String, WordEntry>();

	/**
	 * @param book
	 *            Reads in the parameter of a book from the SearchMenu so that
	 *            any book can be read into the method.
	 */
	public void bookParser(String book) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(book)));
			String line;
			int lineCounter = 1;
			int page = 1;
			// Allows the book to be read in line by line
			while ((line = br.readLine()) != null) {
				// lineCounter counts the lines
				lineCounter++;
				// if lineCounter mod 40 = 0 the page number goes up one
				// this means that every 40 lines the page number
				// goes up....
				if (lineCounter % 40 == 0)
					page++;

				/*
				 * if the string starts any thing between a or A and z or Z is
				 * read and everything else ignored. trim takes out the white
				 * space toLowerCase so that it will be easier to read and
				 * compare the words from the dictionary and stop words split
				 * used to split the lines of text where there is a space this
				 * adds the word to each index of that array/
				 */

				String[] words = line.replaceAll("[^a-zA-Z]+", " ").trim().toLowerCase().split(" ");
				// loop over the words[]
				for (int i = 0; i < words.length; i++) {
					String key = words[i];
					// skip and ignore the stop words
					if (key.isEmpty() || stop.contains(key))
						continue;
					/*
					 * if the new dictionary that we are building on the fly
					 * contains the key i.e. the word at the index in the array
					 */
					if (wordIndex.containsKey(key)) {
						// get the key and addIndex to the wordIndex array so
						// that the page number can be
						// stored for each word[i] or key....
						WordEntry we = wordIndex.get(key);
						we.addIndex(page);
					} else {
						/*
						 * if it doesent already have the key in wordIndex you
						 * need to get the definition of the word and add it to
						 * the Map if it doesent have a definition set the
						 * definition as Undifined...
						 */
						WordEntry we = new WordEntry();
						// "\"" + key + "\"" puts quotes onto the key so that it
						// will match the keys in
						// the dictionary Map
						String wordKey = "\"" + key + "\"";

						String definition = dictionary.get(wordKey);
						if (definition != null) {
							we.setDefinition(definition);
							we.addIndex(page);
						} else {
							we.setDefinition("Undifined");
							we.addIndex(page);
						}
						// adding the key and WordEntry to the wordIndex Map
						wordIndex.put(key, we);
					}
				}

			}
			/*
			 * Create a quick menu on the fly so that you can choose whether to
			 * search a word or down load the wordIndex dictionary to a file
			 */
			System.out.println("Book Finished Parsing.....");
			System.out.println("Choose one of the following: ");
			System.out.println("Option 1: Search word in book. ");
			System.out.println("Option 2: Print dictionary to file.");
			System.out.println("Option 3: Return to Main Menu.");
			int option = s.nextInt();

			if (option == 1) {
				searchWord();
			} else if (option == 2) {
				downloadFile();
			} else if (option == 3) {
				SearchMenu m = new SearchMenu();
			}

		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}

	}

	/**
	 * The method allows the user to pass a word to the Iterator so that is can
	 * be found and definition with the page numbers it apperars on
	 */
	public void searchWord() {
		Iterator<WordEntry> valueIterator = wordIndex.values().iterator();
		Scanner s = new Scanner(System.in);

		while (valueIterator.hasNext()) {
			System.out.println("Enter word you wish to search: ");
			System.out.println("Do you wish to return to menu: Enter [Y]");
			WordEntry value = valueIterator.next();
			String word;

			word = s.nextLine().toLowerCase();
			if (word.equalsIgnoreCase("Y")) {
				// to return to the SearchMenu if required by typing Y ignoring
				// the case
				SearchMenu m = new SearchMenu();
				// if the word doesent exist in the book return the error
			} else if (!wordIndex.containsKey(word)) {
				System.err.println("-----------------------------------");
				System.err.println("WORD NOT THE IN TEXT!!");
				System.err.println("-----------------------------------");
			} else {
				// else print the word with its defiinition and page number
				value = wordIndex.get(word);

				System.out.println("Word: " + word + "\n" + "Definition: " + value.getDefinition().toString() + "\n"
						+ "Page: " + value.getIndices() + "\n");

			}

		}
	}

	/**
	 * The method used to download the wordIndex map that was created with the
	 * words from the selected book.
	 */
	public void downloadFile() {

		try {
			// printwriter used to print the words and definitions from
			// wordIndex
			PrintWriter out = new PrintWriter("Your_Dictionary.txt");
			// Iterator used to loop over the key and value
			Iterator<String> keySetIterator = wordIndex.keySet().iterator();
			Iterator<WordEntry> valueIterator = wordIndex.values().iterator();
			while (keySetIterator.hasNext()) {
				while (valueIterator.hasNext()) {
					String key = keySetIterator.next();
					WordEntry value = valueIterator.next();

					value = wordIndex.get(key);
					// prints to the file and allows it to be formated to
					// seperate lines
					// allows for an easier read
					out.println("Word: " + key + "\n" + "Definition: " + value.getDefinition().toString() + "\n"
							+ "Pages: " + value.getIndices() + "\n");

				}
			}
			// closes the print writer and makes sure all information is flushed
			// out..
			out.flush();
			out.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		SearchMenu m = new SearchMenu();
	}

}
