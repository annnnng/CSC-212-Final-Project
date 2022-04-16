import java.io.File;
import java.util.Scanner;
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
		Place batRuthRoom = new Place("Text/batRuthRoom.txt", null, null, null, null);
		Place livingRoom = new Place("Text/livingRoom.txt", null, null, batRuthRoom, null);

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
				location = livingRoom.goEast();
			}
			// End game
			if (input.contains("quit")) {
				playing = false;
			}
		}
	}

}