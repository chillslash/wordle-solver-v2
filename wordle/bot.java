package wordle;
import java.util.*;

public class bot {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		List<String> words = startup.getWords();

		while (true) {
			System.out.println("Recommended Word: " + utility.getBestWord(words) + " [" + words.size() + " left]");
			System.out.print("Enter your word (l/e): ");
			String word = inputScanner.nextLine();

			if (word.length() == 5) {
				System.out.print("Enter your result: ");
				String userResult = inputScanner.nextLine();

				words = utility.filter(words, word, userResult);
				// String bestWord = null;

				// if (count(userResult, 'n') == 4 && words.size() > 1) {
				// 	List<String> letters = getLastLetters(words, userResult);
				// 	String testWord = filterLastWord(letters);

				// 	System.out.println("There are " + words.size() + " remaining words\n" + words);
				// 	System.out.println("Trying a combination of: " + letters);
				// 	System.out.println("Try: " + testWord);
				// 	System.out.print("Enter your result: ");
				// 	userResult = inputScanner.nextLine();

				// 	bestWord = finalWord(testWord, userResult, letters, words);

				// } else {
				// 	bestWord = getBestWord(words);
				// }

				String bestWord = utility.getBestWord(words);

				System.out.println("\nNext Best Word: " + bestWord);

			} else if (word.equals("l")) {
				System.out.println(words);

			} else if (word.equals("e")) {
				break;

			} else {
				System.out.println("Invalid input");
			}
		}

		inputScanner.close();
	}

}
