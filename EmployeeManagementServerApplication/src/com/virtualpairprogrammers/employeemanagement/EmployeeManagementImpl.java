package com.virtualpairprogrammers.employeemanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
	
	@Resource
	private SessionContext wildfly;
	
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
		
		//Here we are forcing the transaction to be rolled back 
		//by setting property wildfly.setrollbackonly()
		try {
			payrollService.enrollEmployee(employee);
		}catch(ServiceUnavialableException e) {
			wildfly.setRollbackOnly();
			throw e;
		}
		
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
