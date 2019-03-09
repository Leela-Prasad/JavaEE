package com.virtualpairprogrammers.employeemanagement.dataacess;

import java.util.List;

import javax.ejb.Local;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

//This Data Access Bean should not be directly accessed outside
//so we have make this local so that other ejb insdie our application 
//can access for DB Related operations.
@Local
public interface EmployeeDataAccess {

	public abstract void insert(Employee newEmployee);

	public abstract List<Employee> findAll();

	public abstract List<Employee> findBySurname(String surname);
	
}
