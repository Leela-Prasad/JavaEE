package com.virtualpairprogrammers.employeemanagement;

import javax.ejb.Stateless;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
public class ExternalPayrollSystem {

	public void enrollEmployee(Employee employee) throws ServiceUnavialableException {
		throw new ServiceUnavialableException();
	}
}
