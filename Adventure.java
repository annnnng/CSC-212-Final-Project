import java.io.File;
import java.util.*;
/**
 * Class to store game
 *
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

		// Initialise room 
		Place batRuthRoom = new Place("Bat Ruth Room", "Text/batRuthRoom.txt", new ArrayList<Exit>);
		Place livingRoom = new Place("living room","Text/livingRoom.txt", new ArrayList<Exit>);

		// Initialise exit
		

		// Starting location
		Place location = livingRoom;

		boolean playing = true;

		// Start game 
		while (playing){
			location.desc();
			// Print out possible exits
			System.out.println("Exits:\nBat Ruth's room is to your left.\nWhere do you want to go?");
			String input = sc.nextLine();
			// Moving between places
			if (input.contains("left")) {
				location = batRuthRoom;
			}
			// End game
			if (input.contains("quit")) {
				playing = false;
			}
		}
	}

}