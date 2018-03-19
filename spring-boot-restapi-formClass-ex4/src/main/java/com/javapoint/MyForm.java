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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

}
