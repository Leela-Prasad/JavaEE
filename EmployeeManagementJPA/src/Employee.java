import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String surName;
	private String jobRole;
	private int salary;
	
	public Employee() {
		//required by JPA
	}
	
	public Employee(String firstName, String surName, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.jobRole = jobRole;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return firstName + " " + surName;
	}
	
}
