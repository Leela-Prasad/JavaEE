package com.virtualpairprogrammers.employeemanagement.domain;

import java.io.Serializable;

//Here this class should be Serializable as 
//during ejb invocation it will send this object from 
//server to client through network.
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String surName;
	private String jobRole;
	private int salary;
	
	public Employee(String firstName, String surName, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.jobRole = jobRole;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return firstName + " " + surName;
	}
	
}
