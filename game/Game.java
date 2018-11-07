package game;

import java.util.HashMap;
import java.util.Map;

public class Game {
	
	WordFactory factory = null;
	int wordIndex = 0;
	int wordsAmount = 100;
	Map<Character, Integer> missed = new HashMap<Character, Integer>();
	
	public Game(String filename) {
		factory = new WordFactory(filename);
	}

	public String getNextWord() {
		
		wordIndex++;
		
		if (wordIndex == factory.getWords().length) {
			factory.generateWords(wordsAmount, missed);
			wordIndex = 0;
		}
		
		return factory.getWords()[wordIndex];
	}
	
	public String getWord() {
		return factory.getWords()[wordIndex];
	}
	
	public void addMissed(Character letter) {
		missed.put(letter, missed.get(letter) + 1);
	}
	
	public void setWordAmount(int wordsAmount) {
		this.wordsAmount = wordsAmount;
	}
}
