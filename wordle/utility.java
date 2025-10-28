package wordle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class utility {

	public static int count(String word, char letter) {
		int count = 0;
		for (char c : word.toCharArray()) {
			if (c == letter)
				count += 1;
		}
		return count;
	}

	public static List<List<Character>> allResults(){
		List<List<Character>> allResult = new ArrayList<>();
		char[] letterResult = {'g', 'y', 'l'};
		for (char a : letterResult){
			List<Character> result = new ArrayList<>();
			result.add(a);
			for (char b : letterResult){
				result.add(b);
				for (char c : letterResult){
					result.add(c);
				}
			}
			allResult.add(result);
		}	
		return allResult;
	}

	public static String guess(String correctWord, String testWord){
		String result = "";
		List<Character> duplicates = new ArrayList<>();
		for (int i = 0; i < 5; i++){

			if (correctWord.charAt(i) == testWord.charAt(i)){
				result += "g";

			} else {
				for (int c = 0; c < 5; c++){
					if (correctWord.charAt(c) == testWord.charAt(i)
					&& correctWord.charAt(c) != testWord.charAt(c)
					&& !duplicates.contains(correctWord.charAt(c))){
						result += "y";
						duplicates.add(correctWord.charAt(c));
						break;
					}
					if (c == 4){
						result += "n";
					}
				}
			}
		}
		return result;
	}

	public static String getBestWord(List<String> words) {
		if (words.size() == 1){
			return words.get(0);
		}
		if (words.size() == 5759){
			return "tares";
		}

		List<String> freshWords = startup.getWords();
		String bestWord = "";
		Double min = Double.MAX_VALUE;
		
		for (String testWord : freshWords){
			HashMap<String, Integer> N = new HashMap<>();
			for (String correctWord : words){
				String result = guess(correctWord, testWord);
				N.put(result, N.getOrDefault(result, 0) + 1);
			}

			Double score = 0.0;
			for (int n : N.values()){
				score += (Math.pow(n, 2));
			}
			score /= words.size();
			
			if (score < min){
				bestWord = testWord;
				min = score;
			}
		}

		return bestWord;
	}

	public static boolean removeGreen(int i, String eachWord, String word) {
		return eachWord.charAt(i) != word.charAt(i);
	}

	public static boolean removeYellow(int i, String eachWord, String word) {
		if (eachWord.charAt(i) == word.charAt(i)) {
			return true;
		}
		for (int j = 0; j < 5; j++) {
			if (eachWord.charAt(j) == word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean removeNo(int i, String eachWord, String word) {
		for (char c : eachWord.toCharArray()) {
			if (c == word.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public static List<String> filter(List<String> words, String word, String result) {

		List<String> newWords = new ArrayList<>();
		for (String eachWord : words) {
			boolean add = true;
			for (int i = 0; i < 5; i++) {
				if (result.charAt(i) == 'g' && removeGreen(i, eachWord, word)) {
					add = false;
				} else if (result.charAt(i) == 'y' && removeYellow(i, eachWord, word)) {
					add = false;
				} else if (result.charAt(i) == 'n' && removeNo(i, eachWord, word)) {
					add = false;
				}
			}

			if (add) {
				newWords.add(eachWord);
			}
		}

		return newWords;
	}

	public static void main(String[] args) {
		System.out.println(getBestWord(startup.getWords()));
	}

}
