package com.virtualpairprogrammers.employeemanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.virtualpairprogrammers.employeemanagement.dataacess.EmployeeDataAccess;
import com.virtualpairprogrammers.employeemanagement.dataacess.ProductionDao;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

//Stateless annotations tells to server that 
//this class is an EJB.
@Stateless
public class EmployeeManagementImpl implements EmployeeManagementService {

	@Inject
	@ProductionDao
	//@TestingDao
	private EmployeeDataAccess dao;
	
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
		dao.insert(employee);
		
		//Throwing an UNCHECKED EXCEPTION will make the transaction to be
		//rolled back automatically, so employee will not be inserted
		throw new RuntimeException();
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}

}
