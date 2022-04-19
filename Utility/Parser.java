import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

class Parser {
	public static void printText(String filename)
	{
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

	public static void clearScreen() 
	{  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
	}  

	public static void promptEnterKey(Scanner scanner){
   System.out.println("Press \"ENTER\" to continue...");
   scanner.nextLine();
}

	public static void parse(Scanner sc) 
	{
		String input = sc.nextLine();
		
		// HashMap that contains <verb, <object, runnable>> ???
		HashMap<String, HashMap<String, Object>> command = new HashMap<String, HashMap<String, Object>> ();

		HashMap<String, Direction> dir = new HashMap<String, Direction>();

		dir.put("N", Direction.NORTH);
		dir.put("S", Direction.SOUTH);
		dir.put("W", Direction.WEST);
		dir.put("E", Direction.EAST);

		command.put("go", dir);

		// One word command
	}
}