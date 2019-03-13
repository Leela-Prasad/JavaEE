package com.virtualpairprogrammers.employeemanagement.dataacess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
@ProductionDao
public class EmployeeDataAccessProductionVersion implements EmployeeDataAccess {

	//This annotation tells server to inject Entity Manager 
	//whenever any method is called because Entity Manager should be created
	//for every transaction.
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(Employee newEmployee) {
		em.persist(newEmployee);
	}

	@Override
	public List<Employee> findAll() {
	    Query q = em.createQuery("select employee from Employee employee");
	    return q.getResultList();
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surName=:surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

}
