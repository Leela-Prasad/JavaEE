package com.virtualpairprogrammers.employeemanagement.dataacess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
//This Implementation will be eligible for Injection only when this class is 
//declared in src/META-INF/beans.xml file
@Alternative
public class EmployeeDataAccessTestingVersion implements EmployeeDataAccess {

	@Override
	public void insert(Employee newEmployee) {
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee("Leela", "Jagu", "Developer", 1200);
		Employee e2 = new Employee("Prasad", "Jagu", "Tester", 1100);
		employees.add(e1);
		employees.add(e2);
		return employees;
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		return null;
	}

}
