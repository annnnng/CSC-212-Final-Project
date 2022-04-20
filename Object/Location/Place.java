import java.util.*;

/**
 * Class to store info and methods for places
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Place extends Item {

	/** hashMap<direction, exit> of exits */
	private HashMap<Direction, Exit> exitMap = new HashMap<Direction, Exit>();

	/** hashmap<item name, item> of items in place */
	private HashMap<String, Item> itemsList = new HashMap<String, Item>();

	/** hashmap<character name, item> list of character in place */
	private HashMap<String, NPC> NPCList = new HashMap<String, NPC>();

	/** Constructor */
	public Place(String name, String description) {
		super (name, description);
	}

	

	/**
	 * Check if the place has any exit in a direction
	 * 
	 * @arg dir direction
	 */
	public boolean hasExit(Direction dir) {
		return exitMap.containsKey(dir);
	}

	/**
	 * Get exit in a direction, if any
	 * 
	 * @arg dir direction
	 * @throw RuntimeException if there is no exit for a direction
	 */
	public Exit getExit(Direction dir)
			throws RuntimeException {
		if (exitMap.get(dir) == null) {
			throw new RuntimeException();
		} else {
			return exitMap.get(dir);
		}
	}

	/** Clear all exits */
	public void clearExit() {
		exitMap.clear();
	}

	/**
	 * Add exit in a direction
	 * 
	 * @arg dir direction
	 * @arg e exit
	 */
	public void addExit(Direction dir, Exit e) {
		exitMap.put(dir, e);
	}

	/**
	 * Remove exit in a direction
	 * 
	 * @arg dir direction
	 */
	public void removeExit(Direction dir) {
		exitMap.remove(dir);
	}

	public Item getItem(String itemName) {
		if (itemsList.get(itemName) == null) {
			throw new RuntimeException();
		} else {
			return itemsList.get(itemName);
		}
	}

	/** @arg	Item	to add to place */
	public void addItem(Item item) {
		itemsList.put(item.getName(), item);
	}

	/** @return	Item	remove item and return it */
	public void removeItem(String itemName) {
		itemsList.remove(itemName);
	}

	/** @return String string representation */
	@Override public String toString() {
		return (super.toString() + "\n Exit: " + exitMap.toString());
	}

	/** Print description to console */
	@Override public void desc() {
		System.out.println(" Location: " + super.getName());
		// Print available exit
		System.out.println(" Exit: " + exitMap.keySet());
		Parser.printText(super.getDescription());
		System.out.println(new String(new char[50]).replace('\0', '-'));
	}
}