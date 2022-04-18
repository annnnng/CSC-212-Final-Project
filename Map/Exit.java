/**
 * Class to exit info and methods for each place
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Exit {
	private Place toPlace;
	private Direction dir;
	private boolean accessible;

	public Exit(Place toPlace, Direction dir, boolean accessible) {
		this.toPlace = toPlace;
		this.dir = dir;
		this.accessible = accessible;
	}

	public Place getToPlace() {
		return toPlace;
	}

	public void setToPlace(Place toPlace) {
		this.toPlace = toPlace;
	}

	public Direction getDirection() {
		return dir;
	}

	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	public boolean getAccess() {
		return accessible;
	}

	public void setAccess(boolean accessible) {
		this.accessible = accessible;
	}

	public String toString() {
		String str = "";
		return str;
	}
}