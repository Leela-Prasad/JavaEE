package com.virtualpairprogrammers.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

//Stateless annotations tells to server that 
//this class is an EJB.
@Stateless
public class EmployeeManagementImpl implements EmployeeManagementService {

	@Override
	public void registerEmployee(Employee employee) {
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee("Leela", "Jagu", "Developer", 1200);
		Employee e2 = new Employee("Prasad", "Jagu", "Tester", 1100);
		employees.add(e1);
		employees.add(e2);
		return employees;
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return null;
	}

}
