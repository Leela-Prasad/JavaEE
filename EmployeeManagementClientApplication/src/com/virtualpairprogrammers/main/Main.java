package com.virtualpairprogrammers.main;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.virtualpairprogrammers.employeemanagement.EmployeeManagementService;
import com.virtualpairprogrammers.employeemanagement.ServiceUnavialableException;
import com.virtualpairprogrammers.employeemanagement.domain.Employee;

public class Main {

	public static void main(String[] args) throws NamingException {
		Properties jndiProperties = new Properties();
		
		//This value is specific to vendor like driver class in jdbc
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		
		//This value specifies where our App Server is running.
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		
		//This Property is only needed for wildfly
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		
		Context jndi = new InitialContext(jndiProperties);
		EmployeeManagementService service = (EmployeeManagementService) jndi.lookup("EmployeeManagementServerApplication/EmployeeManagementImpl!com.virtualpairprogrammers.employeemanagement.EmployeeManagementService");
		Employee employee = new Employee("user4", "sur4", "Test", 1100);
		try {
			service.registerEmployee(employee);
		} catch (ServiceUnavialableException e) {
			System.out.println("Something happened Wrong");
		}
		
		System.out.println(service.getAllEmployees());
		
	}

}
