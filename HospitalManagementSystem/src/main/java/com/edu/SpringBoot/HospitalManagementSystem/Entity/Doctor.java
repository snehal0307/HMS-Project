package com.edu.SpringBoot.HospitalManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
@Data
@Entity
@Table(name = "Doctor_tbl")
public class Doctor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="mobile_no")
	private long mobile_no;
	@Column(name="doctor_specialist")
	private String doctor_specialist;
	
	@Transient
	private int count;
	public Doctor() {
	
	}

	public Doctor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public Doctor(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Doctor(long mobile_no, long id) {
		super();
		this.id = id;
		this.mobile_no = mobile_no;
	}
	
	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public Doctor(String doctor_specialist, long id) {
		super();
		this.id = id;
		this.doctor_specialist = doctor_specialist;
	}
	
	public String getDoctor_specialist() {
		return doctor_specialist;
	}

	public void setDoctor_specialist(String doctor_specialist) {
		this.doctor_specialist = doctor_specialist;
	}   
}

