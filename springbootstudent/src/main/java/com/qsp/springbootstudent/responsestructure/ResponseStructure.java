package com.qsp.springbootstudent.responsestructure;

import java.util.List;

import com.qsp.springbootstudent.dto.Student;

public class ResponseStructure <T>{
	private String message;
	private int status;
	private T data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
	


