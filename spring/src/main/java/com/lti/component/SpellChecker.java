package com.lti.component;

import org.springframework.stereotype.Component;

@Component("sc")
public class SpellChecker implements SpellCheckInterface{
	
	public void checkSpellingMistakes(String document) {
		
		System.out.println("spell checker executed" + document);
		
	}

}
