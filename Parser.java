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
		ArrayList<String> traverseWords = new ArrayList<String>(Arrays.asList(traverseArr));

		// List of non-object action word
		String[] nonObjWordsArr = { "look", "help", "undo", "save" };
		ArrayList<String> nonObjWords = new ArrayList<String>(Arrays.asList(nonObjWordsArr));

		// List of object action word
		String[] objWordsArr = { "take", "drop" };
		ArrayList<String> objWords = new ArrayList<String>(Arrays.asList(objWordsArr));
	}
}