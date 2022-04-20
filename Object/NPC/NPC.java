/**
 * Class to store info and methods for places
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class NPC extends Item {

	/** affection level, base value 50 */
	private int affectionLvl = 50;

	/** constructor */
	public NPC(String name, String description) {
		super( name,  description);
	}
}