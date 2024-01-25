package com.qsp.springbootstudent.exception;

public class PercentageNotFound extends RuntimeException{
	String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public PercentageNotFound(String message) {
		super();
		this.message=message;
	}

}
