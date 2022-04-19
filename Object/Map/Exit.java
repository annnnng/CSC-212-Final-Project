/**
 * Class for exit info and methods for exit
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Exit {
	/** where */
	private Place toPlace;
	private boolean accessible;

	public Exit(Place toPlace, boolean accessible) {
		this.toPlace = toPlace;
		this.accessible = accessible;
	}

	public Place getToPlace() {
		return toPlace;
	}

	public void setToPlace(Place toPlace) {
		this.toPlace = toPlace;
	}

	public boolean getAccess() {
		return accessible;
	}

	public void setAccess(boolean accessible) {
		this.accessible = accessible;
	}

	public String toString() {
		String str = "To: " + toPlace + "\n Is accessible: " + accessible;
		return str;
	}
}