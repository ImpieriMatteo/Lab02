package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translation;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		this.translation = new ArrayList<>();
	}

	public void setTranslation(String translation) {
		this.translation.add(translation);
	}


	public String getAlienWord() {
		return alienWord;
	}

	public List<String> getTranslation() {
		return translation;
	}
}
