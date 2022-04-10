package com.edu.SpringBoot.HospitalManagementSystem.Service;

import java.util.List;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);
	
    List<Admin> getAllAdmin();

    Admin updateAdmin(Admin admin, long id);

	List<Admin> getAdminByFirstName(String firstName);

	List<Admin> getAdminByLastName(String lastName);

	List<Admin> getAdminByFirstNameAndLastName(String firstName, String lastName);

	List<Admin> getAdminByFirstNameOrLastName(String firstName, String lastName);

	Admin getAdminFullNameById(long id);

	List<Admin> getAdminInDescOrder();

	void deleteAdmin(long id);

	Admin getAdminById(Long id);

	Admin getAdminById(long id);

}


