package com.healthcare.program.enrollees.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollees")
public class Enrollees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "enrollee_name", length = 50, nullable = false, unique = false)
	private String enrolleeName;
	@Column(name = "is_activated", nullable = false, unique = false)
	private boolean isActivated;

	@Column(name = "birth_date", nullable = false, unique = false)
	
	private Date birthDate;
	@Column(name = "phone_num", nullable = true, unique = false)
	private long phoneNum;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dependent_id", nullable = true)
	private Dependent dependent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnrolleeName() {
		return enrolleeName;
	}

	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Dependent getDependent() {
		return dependent;
	}

	public void setDependent(Dependent dependent) {
		this.dependent = dependent;
	}

}
