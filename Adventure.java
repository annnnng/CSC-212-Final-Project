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
		
		// Print intro text
		Parser.printText("Text/intro.txt");
		Parser.promptEnterKey(sc);
		Parser.clearScreen();

		// Starting location
		Place location = 	Map.init();

		boolean playing = true;

		// Start game 
		while (playing){
			location.desc();

			// Moving between places
			// Replace this with parser
			String input = sc.nextLine();
			if (input.contains("w")) {
				try {
					location = location.getExit(Direction.WEST).getToPlace();
				} catch (Exception e) {
					System.err.println("No exit in that direction!");
				}
			} if (input.contains("e")) {
				try {
					location = location.getExit(Direction.EAST).getToPlace();
				} catch (Exception e) {
					System.err.println("No exit in that direction!"); 
					}
			} if (input.contains("s")) {
				try {
					location = location.getExit(Direction.SOUTH).getToPlace();
				} catch (Exception e) {
					System.err.println("No exit in that direction!");
				}
			} if (input.contains("n")) {
				try {
					location = location.getExit(Direction.NORTH).getToPlace();
				} catch (Exception e) {
					System.err.println("No exit in that direction!");
				}
			}
			
			// End game
			if (input.contains("quit")) {
				playing = false;
			}

			Parser.clearScreen();
		}
	}
}