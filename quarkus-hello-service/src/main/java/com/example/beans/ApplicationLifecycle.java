package com.example.beans;

import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

public class ApplicationLifecycle {
	
	public void startup(@Observes StartupEvent event) {
		System.out.println("quarkus service up");
	}
	
	public void shutdown(@Observes ShutdownEvent event) {
		System.out.println("quarkus service down");
	}

}
