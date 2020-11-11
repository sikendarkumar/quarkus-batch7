package com.example;

import javax.ws.rs.Path;

@Path("/some")
public class SomeResource {

		@LOCK
		public void lockResource() {
			System.out.println("reource locked..");
		}

}
