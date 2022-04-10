package com.edu.SpringBoot.HospitalManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Patient;

public interface PatientRepository extends JpaRepository <Patient, Long> {
	
	List<Patient> findByFirstName(String firstName);

	List<Patient> findByLastName(String lastName);

	@Query("select p from Patient p where p.firstName = :name ")//JPQL
    List<Patient> findPatientsByFirstName(@Param("name") String firstName);

    @Query("select p from Patient p where p.firstName =:firstName and p.lastName= :lastName")
	List<Patient> findPatientsByFirstNameAndLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
	List<Patient> findByFirstNameOrLastName(String firstName, String lastName);
	List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select new com.edu.SpringBoot.HospitalManagementSystem.Entity.Patient(p.firstName, p.lastName) from Patient p where p.id = :id")
    Patient findPatientFullNameById(@Param("id") long id);

    @Query("select count(p.id)  from Patient p ORDER BY p.firstName desc")
    List<Patient> findPatientInDescOrder();

    // CRUD
}


