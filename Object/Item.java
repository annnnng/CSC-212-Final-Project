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

	/** text file with description */
	private String description;


	/** constructor */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
  * Constructor.
  * 
  * @param row (required) a line from file
  */
	public Item(String row) {
    //this splits the string by commas, but ignores a comma if it's enclosed by a pair of parentheses
		String[] parse = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

		//sets each attribute to an index of the string array "row"
		this.name = parse[0];
		this.description = parse[1];
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
		// Print out description associated with location
		Parser.printText(description);
	}
}