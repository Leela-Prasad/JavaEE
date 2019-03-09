package com.virtualpairprogrammers.employeemanagement.dataacess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
@ProductionDao
public class EmployeeDataAccessProductionVersion implements EmployeeDataAccess {

	@Override
	public void insert(Employee newEmployee) {
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new Employee("Leela Pr", "Jagu Pr", "Developer", 1200);
		Employee e2 = new Employee("Prasad Pr", "Jagu Pr", "Tester", 1100);
		employees.add(e1);
		employees.add(e2);
		return employees;
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		return null;
	}

}
