package com.edu.SpringBoot.HospitalManagementSystem.Service;

import java.util.List;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Patient;
import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;

public interface PatientService{

	Patient savePatient(Patient patient);
	
	Patient getPatientById(long id);

	List<Patient> getAllPatient();

	Patient updatePatient(Patient patient, long id);

	List<Patient> getPatientByFirstName(String firstName);

	List<Patient> getPatientByLastName(String lastName);

	List<Patient> getPatientByFirstNameAndLastName(String firstName, String lastName);

	List<Patient> getPatientByFirstNameOrLastName(String firstName, String lastName);

	Patient getPatientFullNameById(long id);

	List<Patient> getPatientInDescOrder();

	void deletePatient(long id);

	void deletePatientById(long id);

	
}


