package com.javapoint;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

public class MyForm {

	@FormParam("id")
	int id;
	
	@FormParam("firstName")
	String firstName;
	
	@FormParam("lastName")
	String lastName;

	@FormParam("salary")
	int salary;

	@PathParam("foo")
	String foo;
	
}
