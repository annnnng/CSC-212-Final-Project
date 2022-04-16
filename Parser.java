import java.io.File;
import java.util.Scanner;

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

	public static void parse (Scanner sc) {
		String input = sc.nextLine();
		
	}
}