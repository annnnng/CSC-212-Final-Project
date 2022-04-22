import java.io.File;
import java.util.*;

/**
 * Class to store game
 * /*
 * 
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Adventure {

	private static Scanner sc = new Scanner(System.in);

	// Begin game
	public static void start() {
		// Print intro text
		Parser.printText("Text/intro.txt");
		Parser.promptEnterKey(sc);
		Parser.clearScreen();

		// Initialise map and drop player to starting location
		Place location = Map.init();

		// Switch to end game
		boolean playing = true;

		// Start game
		while (playing) {
			location.desc();

			// Moving between places
			// Replace this with parser
			String input = sc.nextLine();

			// Get rid of captitalisation and random characters
			input = input
					.toLowerCase()
					.replaceAll("[^A-Za-z\\s]", "")
					.replaceAll("\\s{2,}", " ");

			// Split the input into verb and object
			String[] words = input.split(" ");

			// Parser assume correct grammar position in sentence

			// Check if it is a traversal action
			if (words[0].equals("north") ||
					words[0].equals("walk") &&
							words[1].equals("north")) {
				location = location
						.getExit(Direction.NORTH)
						.getToPlace();
			}

			else if (words[0].equals("south") ||
					words[0].equals("walk") &&
							words[1].equals("south")) {
				location = location
						.getExit(Direction.SOUTH)
						.getToPlace();
			}

			else if (words[0].equals("east") ||
					words[0].equals("walk") &&
							words[1].equals("east")) {
				location = location
						.getExit(Direction.EAST)
						.getToPlace();
			}

			else if (words[0].equals("west") ||
					words[0].equals("west") &&
							words[1].equals("west")) {
				location = location
						.getExit(Direction.WEST)
						.getToPlace();
			}

			Parser.clearScreen();
		}
	}
}