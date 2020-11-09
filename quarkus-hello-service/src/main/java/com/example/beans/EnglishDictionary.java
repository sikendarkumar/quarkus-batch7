package com.example.beans;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
@MainDictionary
public class EnglishDictionary implements Dictionary {

	// ..
	public String get(String sentence) {
		return "hello";
	}

}
