/**
 * Class to store info and methods for items
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Item {
	/** name of place */
	private String name;

	/** text file with description when enter Place */
	private String description;

	/** list of attributes and corresponding command */
	

	/** constructor */
	public Item(String name, String description) {
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

	public String toString() {
		String str = "Name: " + name;
		return str;
	}

	public void desc() {
		// Print out where the user is
		System.out.println("Item: " + name);
		// Print out description associated with location
		Parser.printText(description);
	}
}