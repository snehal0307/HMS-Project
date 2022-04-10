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
@Table(name = "Patient_tbl")
public class Patient {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="patient_id")
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="mobile_no")
	private long mobile_No;
	@Column(name="address")
	private String address;
	@Column(name="DOB")
	private String DOB;
	@Column(name="gender")
	private String gender;
	@Column(name="blood_group")
	private String blood_Group;
	@Column(name="weight")
	private String weight;
	@Column(name="patient_disease")
	private String patient_Disease ;
	@Column
	private String password;
	
	    @Transient
		private int count;
		public Patient() {
		super();
		}
    
	public Patient(String firstName, String lastName) {
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getMobile_No() {
		return mobile_No;
	}

	public void setMobile_no(long mobile_No) {
		this.mobile_No = mobile_No;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBlood_Group() {
		return blood_Group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_Group = blood_group;
	}
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getPatient_Disease() {
		return patient_Disease;
	}

	public void setPatient_Disease(String patient_disease) {
		this.patient_Disease = patient_disease;
	}

	public Patient(long id, String email, long mobile_no, String address, String dOB, String gender, String blood_group,
			String weight, String patient_disease, String doctor_id, int count) {
		super();
		this.id = id;
		this.email = email;
		this.mobile_No = mobile_no;
		this.address = address;
		DOB = dOB;
		this.gender = gender;
		this.blood_Group = blood_group;
		this.weight = weight;
		this.patient_Disease = patient_disease;
	    this.count = count;
	}
	
}	


