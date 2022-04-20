import java.io.File;
import java.util.*;

/**
 * Class to read and print text from console and file for game
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Parser {

	/**
	 * Print text from .txt file
	 * 
	 * @arg filenam name of file to prin
	 */
	public static void printText(String filename) {
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clear console
	 */
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Prompt enter or anykey to continue
	 */
	public static void promptEnterKey(Scanner scanner) {
		System.out.println("Press \"ENTER\" to continue...");
		scanner.nextLine();
	}

	/**
	 * Parse two words (Verb Object) command from user input
	 */
	public static void parse(Scanner sc) {

		// List of traversal word
		String[] traverseArr = { "north", "south", "west", "east" };
		ArrayList<String> traverseWords = Arrays.asList(traverseArr);

		// List of non-object action word
		String[] nonObjWordsArr = { "look" };
		ArrayList<String> nonObjWords = Arrays.asList(nonObjWordsArr);

		// List of object action word
		String[] objWordsArr = { "take" };
		ArrayList<String> objWords = Arrays.asList(objWordsArr);

		// Get input
		String input = sc.nextLine();

		// Get rid of captitalisation and random characters
		input
				.toLowerCase()
				.replaceAll("[^A-Za-z\\s]", "")
				.replaceAll("\\s{2,}", " ");

		// Split the input into verb and object
		String[] words = input.split(" ");

		// Parser assume correct grammar position in sentence

		// Check first word is verb and if the verb need object

		// Throw error if verb is not recognize or the first word is not a verb

		// No need to check for object if only one object available (no other choice)

		// Check second word for object to perform action on

		// Check object is reachable

		// Throw error if no object 

	}

	/** Create list of verbs from .txt file for parser */
	public static void createDictionary(String filename) {

	}
}