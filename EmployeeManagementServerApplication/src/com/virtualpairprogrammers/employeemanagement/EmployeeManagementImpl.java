package com.virtualpairprogrammers.employeemanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.virtualpairprogrammers.employeemanagement.dataacess.EmployeeDataAccessImpl;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

//Stateless annotations tells to server that 
//this class is an EJB.
@Stateless
public class EmployeeManagementImpl implements EmployeeManagementService {

	//From Java EE6 if you are invoking a local EJB then the interface for that
	//EJB is optional, this will be useful when you are sure that you have only one
	//implementation.
	@Inject
	private EmployeeDataAccessImpl dao;
	
	//we can instantiate dao using below constructor but this
	//class needs jndi service to be available for unit testing
	//we can also instantiate any ejb using @Inject annotation. and this 
	//will make sure all our dependencies are available at application startup.
	/*public EmployeeManagementImpl() throws NamingException {
		Context jndi = new InitialContext();
		jndi.lookup("friendlyName");
	}*/
	
	@Override
	public void registerEmployee(Employee employee) {
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return null;
	}

}
