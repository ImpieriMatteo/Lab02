package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String, Word> dictionary;

	public Model() {
		this.dictionary = new HashMap<>();
	}
	
	public void addWord(String word, String translation) {
		Word w = new Word(word, translation);
		if(this.dictionary.containsKey(word))
			this.dictionary.replace(word, w);
		else
			this.dictionary.put(word, w);
	}
	
	public String searchWord(String word) {
		if(this.dictionary.containsKey(word))
			return this.dictionary.get(word).getTranslation();
		else
			return null;
	}
}
