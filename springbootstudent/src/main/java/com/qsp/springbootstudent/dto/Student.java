package com.qsp.springbootstudent.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name can't be Blank")
	@NotNull(message = "Name can't be Null")
	private String name;
	@NotBlank(message = "Address can't be Blank")
	@NotNull(message = "Address can't be Null")
	private String address;
	private int age;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@Column(unique = true)
	@Email(regexp = "[a-z0-9._%$+-]+@[a-z0-9]+\\.[a-z]{2,3}",message = "Invalid Email")
	private String email;
	private int securedmarks; //s/t*100 35 fail greater than 35 pass  >=50 <=60 second class
	//first class >=65 <=90 distiction >=90
	//getstudbyemail by phone
	@Min(value = 0)
	private int totalmarks;
	private double percentage;
	private String grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSecuredmarks() {
		return securedmarks;
	}
	public void setSecuredmarks(int securedmarks) {
		this.securedmarks = securedmarks;
	}
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
