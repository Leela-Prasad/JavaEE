package com.virtualpairprogrammers.employeemanagement;

import javax.ejb.Stateless;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
public class ExternalPayrollSystem {

	public void enrollEmployee(Employee employee) throws ServiceUnavialableException {
		double random = Math.random();
		if(random < 0.8) {
			throw new ServiceUnavialableException();
		}else {
			//Do onboarding
		}
		
		
	}
}
