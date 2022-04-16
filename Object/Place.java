import java.util.*;

/**
 * Class to store info and methods for places
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Place {
	/** name of place */
	private String name;
	
	/** text file with description when enter Place */
	private String description;

	/** list of attributes and corresponding command */
	private ArrayList<String> attribute;

	/** where player can go from this Place */
	private Place north;
	private Place south;
	private Place east;
	private Place west;

	/** constructor */
	public Place(String description, Place north, Place south, Place east, Place west) {
		this.description = description;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public void desc() {
		// Print out where the user is
		System.out.println("Current location: Living Place.");
		// Print out description associated with location
		Parser.printText(description);
	}

	public Place goEast() {
		return east;
	}
}