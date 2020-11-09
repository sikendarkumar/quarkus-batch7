package com.example.beans;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SpanishDictionary implements Dictionary {

	// ..
	public String get(String sentence) {
		return "ola";
	}

}
