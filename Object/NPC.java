
/**
 * Class to store info and methods for places
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
import java.io.*;
import java.util.*;

class NPC extends Item {
	/** counter for number of interaction */
	private int counter;

	/** store dialogue */
	private ArrayList<String> dialogueList = new ArrayList<String>();

	/** store correct items */
	private String item;

	/**
	 * constructor
	 */
	public NPC(String name, String description, String dialogue, String item) {
		super(name, description);
		setDialogue(dialogue);
		counter = 0;
		this.item = item;
	}

	public void setDialogue(String dialogue) {
		try {
			File file = new File(dialogue);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				dialogueList.add(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NPC(String row) {
		super(row);
		String[] parse = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		setDialogue(parse[2]);
		counter = 0;
		this.item = parse[3];
	}

	public void setCounter(int newCounter) {
		this.counter = newCounter;
	}

	public int getCounter() {
		return counter;
	}

	/** print out appropriate dialogue */
	public void talk() {
		System.out.println(super.getName() + ": " + "An NPC is talking!");
	}

	public void responsePathway(String response) {
		if (response.equals(item)) {
			System.out.println(dialogueList.get(1));
		} else if (counter < 5) {
			counter = counter + 1;
			System.out.println(super.getName() + "says" + dialogueList.get(counter));
		} 
	}

	/*
	 * public static void counter() {
	 * if (Player.getPlayerLocation() == "Dungeon") {
	 * File file = new File("Data/CharacterData/Batcula/BatculaDialogue.txt");
	 * Scanner sc = new Scanner(file);
	 * boolean rightAnswerFlag = false;
	 * while (sc.hasNextLine()) {
	 * System.out.println("Batcula says" + (sc.nextLine()));
	 * Scanner userResponse = new Scanner(System.in);
	 * String response = userResponse.nextLine();
	 * try {
	 * if (response == "torch") {
	 * rightAnswerFlag = true;
	 * System.out.println(
	 * "“Is that… what I think it is!!?? The secret stash of Edward Cullen! This very bottle contains the most nutrient blood in all of the universe. How else do you think the Cullens sparkle? Oh my, you have my heart indeed!“\n"
	 * );
	 * System.out.
	 * println("Count Batula quickly drinks the elixir and bites you to turn you into a vampire."
	 * );
	 * break;
	 * } else if (response == "Photos") {
	 * System.out.println("No!\n");
	 * } else if (response == "Mirror") {
	 * System.out.println("No!\n");
	 * }
	 * } catch (Exception e) {
	 * System.err.println("Doesn't exist, try again!");
	 * 
	 * }
	 * if (rightAnswerFlag != true) {
	 * System.out.println(
	 * "“Never ever in my life have I been this disrespected. After all the time we’ve spent getting to know each other, this is what you bring me!”\n"
	 * );
	 * System.out.println(
	 * "Prompt: In a passionate fury, Count Batula bites you and casts a spell on you, making all your other suitors repulsed by your efforts! \n"
	 * );
	 * }
	 * }
	 * if (Player.getPlayerLocation() == "Daily Wire") {
	 * File file2 = new File("Data/CharacterData/BatShapiro/ShapiroDialogue.txt");
	 * Scanner sc2 = new Scanner(file2);
	 * rightAnswerFlag = false;
	 * while (sc2.hasNextLine()) {
	 * System.out.println("Bat Shapiro says" + (sc2.nextLine()));
	 * Scanner userResponse = new Scanner(System.in);
	 * String response = userResponse.nextLine();
	 * try {
	 * if (response == "Newspaper") {
	 * rightAnswerFlag = true;
	 * System.out.println(
	 * "“Ugh! You really shouldn’t have! You know I’ve been looking to do an exposé on Dr. Ant Fauci! These are the perfect incriminating photos of him and his great great ant bribing big pharma! That’s it, bring it in!”\n"
	 * );
	 * System.out.println(
	 * "Bat Shapiro gets down on one knee and presents to you the most beautiful ring. He sweeps you off your feet and you run off into the back end of the Daily Wire Studio to get eloped. You lose all your dignity. I mean, really?? You wanted to marry Bat Shapiro?"
	 * );
	 * break;
	 * } else if (response == "Stale pizza") {
	 * System.out.println("No!\n");
	 * } else if (response == "Ipod") {
	 * System.out.println("No!\n");
	 * }
	 * } catch (Exception e) {
	 * System.err.println("Doesn't exist, try again!");
	 * }
	 * }
	 * if (rightAnswerFlag != true) {
	 * System.out.println(
	 * "“You’ve got to be kidding me?!? You’d really think that this was the key to my heart?? You must be delusional! A hypocrite!”\n"
	 * );
	 * System.out.println(
	 * "Bat Shapiro gets pissed off! He kicks you out of the apartment and talks about you on his podcast with Jeroba Rogan. You become an embarrassment in your community for stooping so low as to debate Bat Shapiro. Now none of the suitors are interested in you. \n"
	 * );
	 * }
	 * }
	 * if (Player.getPlayerLocation() == "Bat Ruth Room") {
	 * File file3 = new File("Data/CharacterData/BatRuth/batruthDialogue.txt");
	 * rightAnswerFlag = false;
	 * Scanner sc3 = new Scanner(file3);
	 * while (sc3.hasNextLine()) {
	 * System.out.println("Bat Ruth says" + (sc3.nextLine()));
	 * Scanner userResponse = new Scanner(System.in);
	 * String response = userResponse.nextLine();
	 * try {
	 * if (response == "Ipod") {
	 * rightAnswerFlag = true;
	 * System.out.println(
	 * "“Oh my gosh! We really are meant to be, aren’t we! Being a celebrity this big is really hard, truth be told! I have to keep my vices on the down low. No one else knows this, but I LOVE My Chemical Romance and Nickelback.”\n"
	 * );
	 * System.out.println(
	 * "Bat Ruth grabs you in his arms and whisks you away. He gives you one of his many championship rings and you spend your honeymoon on a mashup tour of his two favorite bands."
	 * );
	 * break;
	 * } else if (response == "Hairspray") {
	 * System.out.println("No!\n");
	 * } else if (response == "Hummus") {
	 * System.out.println("No!\n");
	 * } else if (response == "Mug") {
	 * System.out.println("No!\n");
	 * }
	 * } catch (Exception e) {
	 * System.err.println("Doesn't exist, try again!");
	 * }
	 * }
	 * if (rightAnswerFlag != true) {
	 * System.out.println(
	 * "“How dare you treat a national treasure this way! I’m the best batball player that ever lived, and you can’t take the time to listen to me?? ”\n"
	 * );
	 * System.out.println(
	 * "Bat Ruth challenges you to a game of baseball and absolutely humiliates you on the pitch. You are so ashamed of yourself you change\n"
	 * );
	 * }
	 * 
	 * }
	 * 
	 * if (Player.getPlayerLocation() == "Batman Room") {
	 * File file4 = new File("Data/CharacterData/Batman/BatmanDialogue.txt");
	 * Scanner sc4 = new Scanner(file4);
	 * rightAnswerFlag = false;
	 * while (sc4.hasNextLine()) {
	 * System.out.println("Batman says" + (sc4.nextLine()));
	 * Scanner userResponse = new Scanner(System.in);
	 * String response = userResponse.nextLine();
	 * try {
	 * if (response == "Human Suit") {
	 * rightAnswerFlag = true;
	 * System.out.println(
	 * "“You make my heart glow! You know this was exactly what my set-up was missing here: you in a human suit! Only someone who truly loves me would make such a sacrifice!”\n"
	 * );
	 * System.out.println(
	 * "Batman enlists the both of you on the American classic “The Bachelorette” where you two end up getting married after weeks of cheating and heartbreak. You end up living “happily ever after“"
	 * );
	 * break;
	 * } else if (response == "Check") {
	 * System.out.println("No!\n");
	 * } else if (response == "Roses") {
	 * System.out.println("No!\n");
	 * }
	 * } catch (Exception e) {
	 * System.err.println("Doesn't exist, try again!");
	 * }
	 * }
	 * if (rightAnswerFlag != true) {
	 * System.out.println(
	 * "“Really? This? I had high hopes for you, but I should’ve known when you refused to watch football and eat Buffalo Wild Wings with me. ”\n"
	 * );
	 * System.out.println(
	 * "You absolutely break Batman’s heart and the rest of the suitors are so appalled that they banish you from the game.\n"
	 * );
	 * }
	 * }
	 * if (Player.getPlayerLocation() == "Translyvania") {
	 * File file5 = new
	 * File("Data/CharacterData/CreepyFigure/creepyFigureDialogue.txt");
	 * Scanner sc5 = new Scanner(file5);
	 * while (sc5.hasNextLine()) {
	 * System.out.println("Creepy Figure says" + (sc5.nextLine()));
	 * Scanner userResponse = new Scanner(System.in);
	 * String response = userResponse.nextLine();
	 * try {
	 * if (response == "Ornate Ring") {
	 * System.out.println(
	 * "“Great job! Your valiant efforts have been rewarded and the spooky figure dressed in black gives you your ticket home, a ride on the Peter Pan bus! It’s super late though.”\n"
	 * );
	 * System.out.println("");
	 * break;
	 * } else if (response == "Check") {
	 * System.out.println("No!\n");
	 * } else if (response == "Roses") {
	 * System.out.println("No!\n");
	 * }
	 * } catch (Exception e) {
	 * System.err.println("You can’t leave unless you exit the game.");
	 * }
	 * }
	 * System.out.println("“You can’t leave unless you exit the game. ”\n");
	 * System.out.println("\n");
	 * }
	 * }
	 * }
	 */
}