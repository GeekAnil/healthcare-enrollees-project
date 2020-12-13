package com.healthcare.program.enrollees.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dependent")
public class Dependent {
	@Id
	private int id;
	@Column(name = "dependent_name", length = 50, nullable = false, unique = false)
	private String dependentName;
	@Column(name = "birth_date", nullable = false, unique = false)
	private Date birthDate;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "dependent") 
	private  Enrollees enrollees;
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Enrollees getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(Enrollees enrollees) {
		this.enrollees = enrollees;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
