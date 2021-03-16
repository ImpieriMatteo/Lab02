package it.polito.tdp.alien.model;

public class Word {

	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}


	public String getTranslation() {
		return translation;
	}
}
