package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("te")
public class TextEditor implements TextEditorInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lti.component.TextEditorInterface#loadTextDocument(java.lang.String)
	 */
	// Dependency Injection here.
	@Autowired
	@Qualifier("sc")
	private SpellCheckInterface spellCheck; // this will make the object of the class that implements the interface

	// we made an object of the other calls and now we just use this
	
	public void loadTextDocument(String document) {

		System.out.println("loaded" + document);

		/* SpellChecker a=new SpellChecker(); */
		spellCheck.checkSpellingMistakes(document);
	}

}
