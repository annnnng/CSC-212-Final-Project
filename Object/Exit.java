/**
 * Class to exit info and methods for each place
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Exit {
	private Place fromPlace;
	private Place toPlace;
	private Direction dir;
	private boolean accessible;

	public Exit(Place fromPlace, Place toPlace, Direction dir) {
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.dir = dir;
	}
}