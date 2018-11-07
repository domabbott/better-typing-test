package game;

import java.util.Map;

public class WordFactory {
	
	String filename = null;
	
	public WordFactory(String filename) {
		this.filename = "src/resources/" + filename;
		
		//generate default word list, with roughly equal amounts or each character
	}
	
	public void generateWords(int length, Map<Character, Integer> missedCounts) {
		
	}
	
	public String[] getWords() {
		return null;
	}
	
}
