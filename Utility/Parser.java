import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

class Parser {
	public static void printText(String filename) {
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
	}  

	public static void parse(Scanner sc) {
		String input = sc.nextLine();
		// HashMap that contains <userInput, runnable>
		HashMap<String, String> command = new HashMap<String, String>();

		command.put("N", "NORTH");

	}
}