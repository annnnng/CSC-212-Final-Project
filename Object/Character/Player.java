import java.util.Scanner;
/**
 * Class to store info and methods for player
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Player {
	/** player name */
	private String name;

	/** This constructor creates a new player */
	public Player() {
		Scanner input = new Scanner(System.in);  
    System.out.println("Enter your name: ");
		this.name = input.nextLine(); 
		input.close();
	}
}