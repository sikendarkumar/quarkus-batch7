package com.example.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class GreetingListener {

	public void recordGreetings(@Observes GreetingEvent event) {
		System.out.println("GreetingListener : " + event);
	}

}
