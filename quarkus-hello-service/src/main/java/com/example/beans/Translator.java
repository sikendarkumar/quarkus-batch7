package com.example.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Translator {

	@Inject
	@MainDictionary
	Dictionary dictionary;

	@Counted
	public String translate(String sentence) {
		return dictionary.get(sentence);
	}

}
