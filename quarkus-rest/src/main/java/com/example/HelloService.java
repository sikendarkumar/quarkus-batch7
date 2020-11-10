package com.example;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getMessage() {
		return "hello from spring mvc's controller";
	}
	
}
