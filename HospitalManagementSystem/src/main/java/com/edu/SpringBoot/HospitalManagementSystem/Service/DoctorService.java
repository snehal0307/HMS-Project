package com.edu.SpringBoot.HospitalManagementSystem.Service;

import java.util.List;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Doctor;

public interface DoctorService {
	
	Doctor saveDoctor(Doctor doctor);

    Doctor getDoctorById(long id);

    List<Doctor> getAllDoctor();

    Doctor updateDoctor(Doctor doctor, long id);

	List<Doctor> getDoctorByFirstName(String firstName);

	List<Doctor> getDoctorByLastName(String lastName);

	List<Doctor> getDoctorByFirstNameAndLastName(String firstName, String lastName);

	List<Doctor> getDoctorByFirstNameOrLastName(String firstName, String lastName);

    Doctor getDoctorFullNameById(long id);

	List<Doctor> getDoctorInDescOrder();

	void deleteDoctor(long id);

	void deleteDoctorById(long id);	
}

