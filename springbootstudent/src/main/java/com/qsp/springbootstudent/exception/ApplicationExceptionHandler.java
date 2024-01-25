package com.qsp.springbootstudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.qsp.springbootstudent.responsestructure.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with the given Id not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> EmailNotFoundExceptionHandler(IdNotFound ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("employee with the given name not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with the given name not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	

}
