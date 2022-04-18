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
	private ArrayList<Exit> exit;

	/** constructor */
	public Place(String name, String description, ArrayList<Exit> exit) {
		this.name = name;
		this.description = description;
		this.exit = exit;
	}

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

	public ArrayList<Exit> getExit() {
		return exit;
	}

	public void clearExit() {
		exit.clear();
	}

	public void addExit(Exit e) {
		exit.add(e);
	}

	public void deleteExit(Exit e) {
		exit.remove(e);
	}

	public String toString() {
		String str = "";
		return str;
	}

	public void desc() {
		// Print out where the user is
		System.out.println("Current location: " + name);
		// Print out description associated with location
		Parser.printText(description);
	}
}