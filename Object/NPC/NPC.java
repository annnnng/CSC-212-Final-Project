/**
 * Class to store info and methods for places
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class NPC extends Item {

	/** constructor */
	public NPC(String name, String description) {
		super(name, description);
	}

	public void talk() {
		System.out.println("An NPC is talking!");
	}
}