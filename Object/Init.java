import java.util.*;
import java.io.*;

/**
 * Class to initialise place and exit as a graph
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Init {

	// Starting position
	private Place start;

	/* ArrayList that stores all the instances of Place */
	private HashMap<String, Place> placeMap = new HashMap<String, Place>();

	/* Reads file then creates and adds a Place from each line in the file */
	public void createRoom(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) {
			// take each line in CSV and save to line
			String line = file.nextLine();
			Place p = new Place(line);
			placeMap.put(p.getName(), p);
		}
		file.close();
	}

	/* Reads file then creates and adds an Item from each line in the file */
	public void createItem(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) {
			// take each line in CSV and save to line
			String line = file.nextLine();
			Item item = new Item(line);
			// Add item to rooms
			String[] parse = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			placeMap.get(parse[2]).addItem(item);
		}
		file.close();
	}

	/* Reads file then creates and adds a NPC from each line in the file */
	public void createNPC(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) {
			// take each line in CSV and save to line
			String line = file.nextLine();
			NPC npc = new NPC(line);
			// Add npc to rooms
			String[] parse = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			placeMap.get(parse[2]).addNPC(npc);
		}
		file.close();
	}

	/* Reads file then creates and adds an Exit from each line in the file */
	public void createExit(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		// skip header
		file.nextLine();
		while (file.hasNextLine()) {
			// take each line in CSV and save to line
			String line = file.nextLine();
			String[] parse = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			Place source = placeMap.get(parse[0]);

			boolean access = true;

			if (!(parse[1].isEmpty())) {
				if (parse[1].contains("[()]")) {
					access = false;
				}
				source.addExit(Direction.NORTH, new Exit(placeMap.get(parse[1]), access));
			}

			if (!(parse[2].isEmpty())) {
				if (parse[2].contains("[()]")) {
					access = false;
				}
				source.addExit(Direction.SOUTH, new Exit(placeMap.get(parse[2]), access));
			}

			if (!parse[3].isEmpty()) {
				if (parse[3].contains("[()]")) {
					access = false;
				}
				source.addExit(Direction.EAST, new Exit(placeMap.get(parse[3]), access));
			}

			if (!parse[4].isEmpty()) {
				if (parse[4].contains("[()]")) {
					access = false;
				}
				source.addExit(Direction.WEST, new Exit(placeMap.get(parse[4]), access));
			}

		}
		file.close();
	}

	/* Initialise game objects */
	public Init() {
		// Create room from .txt file
		createRoom("Data/LocationData/placeData.txt");
		this.start = placeMap.get("Living Room");

		// Create exits between rooms
		createExit("Data/LocationData/exitData.txt");

		// Create item from .txt file and add to room
		createItem("Data/LocationData/itemData.txt");

		// Create NPC from .txt file and add to room
		createNPC("Data/LocationData/NPCData.txt");

		// Add door
		Door d = new Door ("mirror", "Data/CharacterData/Batcula/MirrorBat.txt", placeMap.get("Transylvania"), false);
		placeMap.get("Dungeon").addDoor(d);
	}

	/* @args Place starting position */
	public Place getStart() {
		return start;
	}

	/* adds one place object to the collection */
	public void addPlace(Place p) {
		placeMap.put(p.getName(), p);
	}

	/* returns the Place stored in the collection */
	public Place getPlace(String name) {
		return placeMap.get(name);
	}

	/* deletes the Place stored in the collection */
	public void removePlace(String name) {
		placeMap.remove(name);
	}

	/* return the total number of Places stored in the collection. */
	public int size() {
		return placeMap.size();
	}

}