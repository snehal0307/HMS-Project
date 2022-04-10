package com.edu.SpringBoot.HospitalManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long> {
	
	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	@Query("select a from Admin a where a.firstName =:name ")//JPQL
    List<Admin> findAdminByFirstName(@Param("name") String firstName);

    @Query("select a from Admin a where a.firstName =:firstName and a.lastName =:lastName")
	List<Admin> findAdminsByFirstNameAndLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
	List<Admin> findByFirstNameOrLastName(String firstName, String lastName);
	List<Admin> findByFirstNameAndLastName(String firstName, String lastName);

    
    @Query("Select new com.edu.SpringBoot.HospitalManagementSystem.Entity.Admin(a.firstName, a.lastName) from Admin a where a.id = :id") // Using
	// Constructor
    Admin findAdminFullNameById(@Param("id") long id);

    @Query("select count(a.id)  from Admin a ORDER BY a.firstName desc")
    List<Admin> findAdminInDescOrder();

	Admin findAdminById(Long id);


// CRUD
}


