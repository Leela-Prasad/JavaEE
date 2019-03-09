package com.virtualpairprogrammers.employeemanagement.dataacess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
public class EmployeeDataAccessImpl {

	public void insert(Employee newEmployee) {
	}

	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee("Leela", "Jagu", "Developer", 1200);
		Employee e2 = new Employee("Prasad", "Jagu", "Tester", 1100);
		employees.add(e1);
		employees.add(e2);
		return employees;
	}

	public List<Employee> findBySurname(String surname) {
		return null;
	}

}
