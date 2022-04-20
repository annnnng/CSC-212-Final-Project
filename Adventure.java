import java.io.File;
import java.util.*;

/**
 * Class to store game
 /*
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Adventure {

	private static Scanner sc = new Scanner(System.in);

	// Begin game
	public static void start(){

		Player p = new Player("Test");
		
		// Print intro text
		Parser.printText("Text/intro.txt");
		Parser.promptEnterKey(sc);
		Parser.clearScreen();

		// Initialise map and drop player to starting location
		Place location = Map.init();

		// Switch to end game
		boolean playing = true;

		// Start game 
		while (playing){
			location.desc();

			// Moving between places
			// Replace this with parser
			String input = sc.nextLine();
			if (input.contains("w")) {
				location = location.getExit(Direction.WEST).getToPlace();
			} if (input.contains("e")) {
				location = location.getExit(Direction.EAST).getToPlace();
			} if (input.contains("s")) {
				location = location.getExit(Direction.SOUTH).getToPlace();
			} if (input.contains("n")) {
				location = location.getExit(Direction.NORTH).getToPlace();
			}
			
			// End game
			if (input.contains("quit")) {
				playing = false;
			}

			Parser.clearScreen();
		}
	}
}