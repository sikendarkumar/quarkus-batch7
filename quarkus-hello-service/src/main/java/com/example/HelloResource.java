package com.example;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import com.example.beans.Food;
import com.example.beans.GreetingEvent;
import com.example.beans.Translator;

@Path("/api/hello")
public class HelloResource {

	private static Logger logger = Logger.getLogger(HelloResource.class);

	@ConfigProperty(name = "greeting.message", defaultValue = "hello")
	String message;

	@ConfigProperty(name = "greeting.who", defaultValue = "unknown")
	String who;

	@ConfigProperty(name = "greeting.messages", defaultValue = "hello")
	List<String> messages;

	@Inject
	Config config;

	@Inject
	Translator translator;

	@Inject
	@Named("non-veg")
	Food food;

	@PostConstruct
	public void init() {
		// ...
	}

	@PreDestroy
	public void destroy() {
		// ..
	}

	@Inject
	Event<GreetingEvent> event;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {

//		for(String p:config.getPropertyNames()) {
//			System.out.println(p);
//		}

//		logger.info("i said hello");

//		String m = config.getOptionalValue("greeting.message", String.class).orElse("hello");
//		String w = config.getOptionalValue("greeting.who", String.class).orElse("unknown");
//
//		return m + " " + w;

		event.fire(new GreetingEvent());

		return translator.translate("hello");
	}

}