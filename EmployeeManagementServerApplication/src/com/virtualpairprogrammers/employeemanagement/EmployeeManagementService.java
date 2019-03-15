package com.virtualpairprogrammers.employeemanagement;

import java.util.List;

import javax.ejb.Remote;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

//This interface is annotated with Remote
//so that clients will be given access to invoke
//ejb which implements this interface.
@Remote
public interface EmployeeManagementService {

	public void registerEmployee(Employee employee) throws ServiceUnavialableException;
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> searchBySurname(String surname);
	
}
