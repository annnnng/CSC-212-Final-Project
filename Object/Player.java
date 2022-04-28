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

	/**
	 * @args name String name of item to get
	 */
	public Item getInventory(String name) {
		return inventory.get(name);
	}

	/**
	 * @args name String name of item to remove
	 */
	public void removeInventory(String name) {
		inventory.remove(name);
	}

	/** print out inventory for user */
	public void checkInventory() {
		System.out.println("Inventory: " + inventory.keySet());
	}

}