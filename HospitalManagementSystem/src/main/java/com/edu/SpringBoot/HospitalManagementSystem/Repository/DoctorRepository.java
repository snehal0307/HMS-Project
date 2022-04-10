package com.edu.SpringBoot.HospitalManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Doctor;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {
	
	List<Doctor> findByFirstName(String firstName);

	List<Doctor> findByLastName(String lastName);

	@Query("select d from Doctor d where d.firstName = :name ")//JPQL
    List<Doctor> findDoctorsByFirstName(@Param("name") String firstName);
	
	@Query("select d from Doctor d where d.firstName =:firstName and d.lastName= :lastName")
	List<Doctor> findDoctorsByFirstNameAndLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
	List<Doctor> findByFirstNameOrLastName(String firstName, String lastName);
	List<Doctor> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select new com.edu.SpringBoot.HospitalManagementSystem.Entity.Doctor(d.firstName, d.lastName) from Doctor d where d.id = :id")
    Doctor findDoctorFullNameById(@Param("id") long id);

    @Query("select count(d.id)  from Doctor d ORDER BY d.firstName desc")
    List<Doctor> findDoctorInDescOrder();

	// CRUD
}
