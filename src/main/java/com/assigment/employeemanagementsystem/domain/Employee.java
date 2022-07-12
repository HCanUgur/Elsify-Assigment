package com.assigment.employeemanagementsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to create a table of this class
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	By @GeneratedValue, JPA makes a unique key automatically and applies the key to the field having @Id
	private int id;
	private String firstName;
	private String lastName;
	private String dep;

	private int salary;

	public Employee() {
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDep() {
		return dep;
	}

	public void setEmail(String email) {
		this.dep = dep;
	}

}
