package com.qsp.springbootstudent.exception;

public class IdNotFound extends RuntimeException {
	String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public IdNotFound(String message) {
		super();
		this.message=message;
	}

	

}
