package com.example;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.runtime.annotations.CommandLineArguments;

import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api/todos")
public class TodoResource {

	@CommandLineArguments
	String[] args;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getTodos(@QueryParam(value = "type") String type) {
		System.out.println(type);
		return List.of();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo getTodo(@PathParam(value = "id") int id, @HeaderParam("Accept-Language") String lang) {
		return new Todo(id, "sample", false);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(@Valid Todo todo, @Context UriInfo uriInfo) {
		// ..
		System.out.println(uriInfo.getAbsolutePath());
		return Response.status(Status.CREATED).entity(todo).build();
	}

}
