/**
 * Class for exit info and methods for exit
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Exit {
	/** where exit lead to */
	private Place toPlace;
	/** can the user use this exit */
	private boolean accessible;

	/** constructor */
	public Exit(Place toPlace, boolean accessible) {
		this.toPlace = toPlace;
		this.accessible = accessible;
	}

	/** @return Place get where exit lead to */
	public Place getToPlace() {
		return toPlace;
	}

	/** set where exit lead to */
	public void setToPlace(Place toPlace) {
		this.toPlace = toPlace;
	}

	/** @return boolean true if user can use this exit */
	public boolean getAccess() {
		return accessible;
	}

	/**
	 * set exit accisibility
	 * 
	 * @arg accesible true if user can use, false 	otherwis
	 */
	public void setAccess(boolean accessible) {
		this.accessible = accessible;
	}

	/** @return	String	string representation */
	public String toString() {
		String str = "To: " + toPlace + ", Is accessible: " + accessible;
		return str;
	}
}