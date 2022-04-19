import java.util.*;
import java.util.HashMap;

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

	/** list of exits */
	private HashMap<Direction, Exit> exitMap = new HashMap<Direction, Exit>();

	/** list of items in place */
	private HashSet<Item> itemsList = new HashSet<Item>();

	/** Constructor */
	public Place(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/** @return name of place */
	public String getName() {
		return name;
	}

	/** Set name */
	public void setName(String name) {
		this.name = name;
	}

	/** Get description */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description
	 * 
	 * @arg description string of text filename
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/** @return String string representation */
	public String toString() {
		String str = "Name: " + name;
		return str;
	}

	/** Print description to console */
	public void desc() {
		// Print out where the user is
		System.out.println("Current location: " + name);
		// Print available exit
		System.out.println(" Exit: " + exitMap.keySet());
		// Print out description associated with location
		Parser.printText(description);
		System.out.println(new String(new char[50]).replace('\0', '-'));
	}
}