package wordle;
import java.io.*;
import java.util.*;

public class startup {

	public static List<String> getWords() {
		File file = new File("wordle/words.txt");
		Scanner scanner = null;
		List<String> words = new ArrayList<>();

		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				words.add(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return words;
	}
}
