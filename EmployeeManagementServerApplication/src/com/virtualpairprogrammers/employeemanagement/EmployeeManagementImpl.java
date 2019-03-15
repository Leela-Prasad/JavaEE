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
	
	@Inject
	private ExternalPayrollSystem payrollService;
	
	//we can instantiate dao using below constructor but this
	//class needs jndi service to be available for unit testing
	//we can also instantiate any ejb using @Inject annotation. and this 
	//will make sure all our dependencies are available at application startup.
	/*public EmployeeManagementImpl() throws NamingException {
		Context jndi = new InitialContext();
		jndi.lookup("friendlyName");
	}*/
	
	@Override
	public void registerEmployee(Employee employee) throws ServiceUnavialableException {
		dao.insert(employee);
		
		//As payroll Service is throwing a CHECKED Exception and if something
		//happens wrong also it will not rollback the transaction as it is a 
		//CHECKED EXCEPTION i.e., still employee will be inserted.
		payrollService.enrollEmployee(employee);
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
