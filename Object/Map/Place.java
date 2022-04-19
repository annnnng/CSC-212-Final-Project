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

	/** constructor */
	public Place(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/** @return name of place */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean hasExit(Direction dir) {
		return exitMap.containsKey(dir);
	}

	public Exit getExit(Direction dir) {
		if (exitMap.get(dir) == null) {
			throw new RuntimeException();
		} else {
			return exitMap.get(dir);
		}
	}

	public void clearExit() {
		exitMap.clear();
	}

	public void addExit(Direction dir, Exit e) {
		exitMap.put(dir, e);
	}

	public void removeExit(Direction dir) {
		exitMap.remove(dir);
	}

	public String toString() {
		String str = "Name: " + name;
		return str;
	}

	public void desc() {
		System.out.println(new String(new char[50]).replace('\0', '-'));
		// Print out where the user is
		System.out.println("Current location: " + name);
		// Print available exit
		System.out.println(" Exit: " + exitMap.keySet());
		// Print out description associated with location
		Parser.printText(description);
		System.out.println(new String(new char[50]).replace('\0', '-'));
	}
}