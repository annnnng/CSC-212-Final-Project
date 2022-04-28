import java.io.File;
import java.util.*;

/**
 * Class to store game
 * /*
 * 
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Adventure {

	private static Scanner sc = new Scanner(System.in);

	// Begin game
	public static void start() {
		// Initialise player
		Player player = new Player("Sabrina");

		// Initialise map and drop player to starting location
		Init map = new Init();
		Place location = map.getStart();

		// Print intro text
		Parser.printText("Data/UtilityText/intro.txt");
		Parser.promptEnterKey(sc);
		Parser.clearScreen();

		// Switch to end game
		boolean playing = true;

		// Start game
		while (playing) {
			// Switch to change room
			boolean changeRoom = false;
			location.desc();

			// loop to keep actions going within a specific room
			while (!changeRoom) {

				// takes in the user input and then reads it
				String input = sc.nextLine();

				// Get rid of captitalisation and random characters
				input = input
						.toLowerCase()
						.replaceAll("[^A-Za-z\\s]", "")
						.replaceAll("\\s{2,}", " ");

				// Split the input into verb and object
				String[] words = input.split(" ");

				// Parser assumes correct grammar position in sentence
				// MOVING COMMAND
				if (words[0].equals("north") ||
						words[0].equals("walk") &&
								words[1].equals("north")) {
					Place newLocation = location
							.getExit(Direction.NORTH)
							.getToPlace();
					if (newLocation != null) {
						location = newLocation;
						changeRoom = true;
					} else {
						System.err.println("Can't go there!");
					}
				}

				else if (words[0].equals("south") ||
						words[0].equals("walk") &&
								words[1].equals("south")) {
					Place newLocation = location
							.getExit(Direction.SOUTH)
							.getToPlace();
					if (newLocation != null) {
						location = newLocation;
						changeRoom = true;
					} else {
						System.err.println("Can't go there!");
					}

				}

				else if (words[0].equals("east") ||
						words[0].equals("walk") &&
								words[1].equals("east")) {
					Place newLocation = location
							.getExit(Direction.EAST)
							.getToPlace();
					if (newLocation != null) {
						location = newLocation;
						changeRoom = true;
					} else {
						System.err.println("Can't go there!");
					}
				}

				else if (words[0].equals("west") ||
						words[0].equals("walk") &&
								words[1].equals("west")) {
					Place newLocation = location
							.getExit(Direction.WEST)
							.getToPlace();
					if (newLocation != null) {
						location = newLocation;
						changeRoom = true;
					} else {
						System.err.println("Can't go there!");
					}
				}

				// ITEM COMMAND

				// allows you to examine an item
				else if (words[0].equals("examine")) {
					if (location.getItem(words[1]) != null) {
						location.getItem(words[1]).desc();
					} else if (location.getDoor(words[1]) != null) {
						System.out.println("Izza me, doorio!");
						Place newLocation = location
								.getDoor(words[1]).useDoor();
						if (newLocation != null) {
							location = newLocation;
							changeRoom = true;
						} else {
							System.out.println("Izza me, lockio!");
						}
					} else {
						System.out.println("No such item!");
					}
				}

				// allows you to take an item
				else if (words[0].equals("take")) {
					if (location.getItem(words[1]) != null) {
						// adds item to inventory
						player.addInventory(
								location.getItem(words[1]));
						// takes item out of the room
						location.removeItem(words[1]);
						System.out.println(
								"You pick up " + words[1]);
					} else {
						System.out.println("No such item!");
					}
				}

				// allows you to drop an item
				else if (words[0].equals("drop")) {
					if (player.getInventory(words[1]) != null) {
						// adds item to room
						location.addItem(
								player.getInventory(words[1]));
						// removes item from player inventory
						player.removeInventory(words[1]);
						System.out.println(
								"You drop " + words[1]);
					} else {
						System.err.println("Can't drop that!");
					}
				}

          else if(words[0].equals("smash"))
                  {
                    System.out.println("Welp... you smashed it. What a mess you've made.");
                  }
          else if(words[0].equals("Listen"))
          {
            System.out.println("Really? My chemical romance?");
          }
          else if(words[0].equals("eat"))
          {
            player.removeInventory(words[1]);
            System.out.println("Yum!");
          }
          else if(words[0].equals("wear"))
          {
            System.out.println("Cute, but at what cost?");
          }
          else if(words[0].equals("sell"))
          {
            System.out.println("Thank god you had the smarts to get rid of it! Had you not sold the ring, you would have been cursed and stuck in Transylvania for eternity!");
          }
          else if(words[0].equals("read"))
          {
            System.out.println("The pages have illegible runes, you really think you can crack the code?");
          }

				// prints inventory to the screen
				else if (words[0].equals("check") &&
						words[1].equals("inventory")) {
					player.checkInventory();
				}

				// NPC COMMANDS

				else if (words[0].equals("talk")) {
					if (location.getNPC(words[1]) != null) {
						location
								.getNPC(words[1])
								.talk();
					} else {
						System.out.println("No such person here!");
					}
				}

				// UTILITY COMMAND

				// allows you to acess the help menu to understand directions
				else if (words[0].equals("help")) {
					Parser.clearScreen();
					Parser.printText("Data/UtilityText/help.txt");
					Parser.promptEnterKey(sc);
					// Move back to game
					changeRoom = true;
				}

				else {
					System.out.println("I don't understand that!");
				}

			}

			Parser.clearScreen();
		}
	}
}
