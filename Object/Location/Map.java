import java.util.*;
import com.google.common.graph.*;

/**
 * Class to initialise place and exit as a graph
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Map {
	/** Filepath to .txt file for places */
	private String filepath;

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

		livingRoom.addExit(Direction.WEST, new Exit(batRuthRoom, true));
		livingRoom.addExit(Direction.EAST, new Exit(batmanRoom, true));
		livingRoom.addExit(Direction.NORTH, new Exit(dungeon, true));
		livingRoom.addExit(Direction.SOUTH, new Exit(dailyWire, true));

		dungeon.addExit(Direction.SOUTH, new Exit(livingRoom, true));
		dungeon.addExit(Direction.EAST, new Exit(transylvania, false));

		transylvania.addExit(Direction.WEST, new Exit(dungeon, true));

		batRuthRoom.addExit(Direction.EAST, new Exit(livingRoom, true));

		dailyWire.addExit(Direction.NORTH, new Exit(livingRoom, true));

		batmanRoom.addExit(Direction.WEST, new Exit(livingRoom, true));

		return livingRoom;
	}

	public static void initGuava() {
		// Initialise room
		Place batRuthRoom = new Place("Bat Ruth Room", "Text/batRuthRoom.txt");
		Place livingRoom = new Place("Living Room", "Text/livingRoom.txt");
		Place dungeon = new Place("Dungeon", "Text/dungeon.txt");
		Place transylvania = new Place("Transylvania", "Text/transylvania.txt");
		Place batmanRoom = new Place("Batman Room", "Text/batmanRoom.txt");
		Place dailyWire = new Place("Daily Wire", "Text/dailyWire.txt");
		
		MutableValueGraph<Place, Direction> graph =
			ValueGraphBuilder
			.undirected()
			.allowsSelfLoops(true)
			.build();
 graph
	 .putEdgeValue(batRuthRoom, livingRoom, Direction.WEST);
	}

	/**
	 * Initialise map from .txt file containing adjacency matrix
	 * 
	 * @return starting position
	 */
	public void readFile(String filename) {

	}

	/**
	 * Export map as .txt file as adjacency matrix
	 */
	public void writeFile(String filename) {

	}

	/** @return String stringr representation */
	public String toString() {
		String str = "";
		return str;
	}

}