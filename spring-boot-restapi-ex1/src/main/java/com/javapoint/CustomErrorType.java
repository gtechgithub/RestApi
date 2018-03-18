package com.javapoint;

public class CustomErrorType {

	private String errorMessage;
	
	CustomErrorType(String errorMessage){
		this.errorMessage= errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
