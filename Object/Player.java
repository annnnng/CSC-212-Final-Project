import java.util.*;

/**
 * Class to store info and methods for players
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Player {
	/** player's name */
	private String name;

	/** current location */
	private Place location;

	/** inventory */
	private HashMap<String, Item> inventory = new HashMap<String, Item>();

	/** store scenario that already happened so it won't be prompted again */

	/** store in progress quest & challenge */

	/** store completed quest */

	/** constructor */
	public Player(String name) {
		this.name = name;
	}

	/** get player current location */
	public Place getPlayerLocation() {
		return location;
	}

	/** set player current location */
	public void setPlayerLocation(Place location) {
		this.location = location;
	}

	/**
	 * @args i Item to add to inventory
	 */
	public void addInventory(Item i) {
		inventory.put(i.getName(), i);
	}
}