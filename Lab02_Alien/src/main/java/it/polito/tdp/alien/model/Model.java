package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

	private Map<String, WordEnhanced> dictionary;

	public Model() {
		this.dictionary = new HashMap<>();
	}
	
	public void addWord(String word, String translation) {
		if(this.dictionary.containsKey(word)) {
			WordEnhanced temp = this.dictionary.get(word);
			if(!temp.getTranslation().contains(translation))
				temp.setTranslation(translation);
		}
		else {
			WordEnhanced temp = new WordEnhanced(word);
			temp.setTranslation(translation);
			this.dictionary.put(word, temp);
		
		}
	}
	
	public List<String> searchWord(String word) {
		if(this.dictionary.containsKey(word))
			return this.dictionary.get(word).getTranslation();
		else if(word.contains("?")) {
			List<String> temp = new ArrayList<>();
			for(String s : this.dictionary.keySet()) {
				int matches = 0;
				for(int i=0; i<s.length(); i++) {
					if(i<word.length()) {
						if(s.charAt(i)==word.charAt(i))
							matches++;
						}
					else {
						matches = -1;
						break;
					}
				}
				if(matches==word.length()-1) {
					temp.add(s+": "+this.dictionary.get(s).getTranslation().toString());
				}
			}
			if(temp!=null)
				return temp;
		}
		return null;
	}
}
