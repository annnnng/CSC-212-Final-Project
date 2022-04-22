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
			boolean changeRoom = false;

			// loop to keep actions going within a specific room
			while (!changeRoom) {
				location.desc();

				// takes in the user input and then reads it
				String input = sc.nextLine();

				// Get rid of captitalisation and random characters
				input = input
						.toLowerCase()
						.replaceAll("[^A-Za-z\\s]", "")
						.replaceAll("\\s{2,}", " ");

				// Split the input into verb and object
				String[] words = input.split(" ");

				// Parser assumes correct grammar position in sentence
				// Check if it is a traversal action
				if (words[0].equals("north") ||
						words[0].equals("walk") &&
								words[1].equals("north")) {
					location = location
							.getExit(Direction.NORTH)
							.getToPlace();
					changeRoom = true;
				}

				else if (words[0].equals("south") ||
						words[0].equals("walk") &&
								words[1].equals("south")) {
					location = location
							.getExit(Direction.SOUTH)
							.getToPlace();
					changeRoom = true;
				}

				else if (words[0].equals("east") ||
						words[0].equals("walk") &&
								words[1].equals("east")) {
					location = location
							.getExit(Direction.EAST)
							.getToPlace();
					changeRoom = true;
				}

				else if (words[0].equals("west") ||
						words[0].equals("west") &&
								words[1].equals("west")) {
					location = location
							.getExit(Direction.WEST)
							.getToPlace();
					changeRoom = true;
				}
        //allows you to take an item

				if (words[0].equals("take")) {
					location.getItem(words[1]);
				}
        //allows you to drop an item

				if (words[0].equals("drop")) {
					location.getItem(words[1]);
				}
        //allows 

				if (words[0].equals("help")) {
					Parser.printText("Text/help.txt");
				}

				Parser.clearScreen();
			}
		}
	}
}
