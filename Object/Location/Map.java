import java.util.*;

/**
 * Class to initialise place and exit as a graph
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Map {

	// Starting position
	Place start;

	public Map() {
		this.start = init();
	}

	/**
	 * Manually initialise map
	 * 
	 * @return starting position
	 */
	public static Place init() {
		// Initialise room
		Place batRuthRoom = new Place("Bat Ruth Room", "Text/batRuthRoom.txt");
		Place livingRoom = new Place("Living Room", "Text/livingRoom.txt");
		Place dungeon = new Place("Dungeon", "Text/dungeon.txt");
		Place transylvania = new Place("Transylvania", "Text/transylvania.txt");
		Place batmanRoom = new Place("Batman Room", "Text/batmanRoom.txt");
		Place dailyWire = new Place("Daily Wire", "Text/dailyWire.txt");

		// LIVING ROOM

		livingRoom.addExit(Direction.WEST, new Exit(batRuthRoom, true));
		livingRoom.addExit(Direction.EAST, new Exit(batmanRoom, true));
		livingRoom.addExit(Direction.NORTH, new Exit(dungeon, true));
		livingRoom.addExit(Direction.SOUTH, new Exit(dailyWire, true));

		// Add NPC

		livingRoom.addNPC( new NPC("butler", "Object/NPC/Dialogue/butler.txt") );

		// Add Item 

		livingRoom.addItem(new Item("rose","rose.txt"));

		// DUNGEON

		dungeon.addExit(Direction.SOUTH, new Exit(livingRoom, true));
		dungeon.addExit(Direction.EAST, new Exit(transylvania, false));

		// TRANSYLVANIA

		transylvania.addExit(Direction.WEST, new Exit(dungeon, true));

		// BAT RUTH/MAN CAVE
		batRuthRoom.addExit(Direction.EAST, new Exit(livingRoom, true));

		// DAILY WIRE

		dailyWire.addExit(Direction.NORTH, new Exit(livingRoom, true));

		// BATMAN

		batmanRoom.addExit(Direction.WEST, new Exit(livingRoom, true));

		return livingRoom;
	}
}