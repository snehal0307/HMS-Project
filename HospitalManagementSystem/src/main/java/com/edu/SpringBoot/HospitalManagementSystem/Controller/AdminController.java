package com.edu.SpringBoot.HospitalManagementSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Admin;
import com.edu.SpringBoot.HospitalManagementSystem.Service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private AdminService adminService;

	public AdminController(AdminService adminService) 
	{
		super();
		this.adminService = adminService;
	}
	
	@PostMapping
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) 
	{
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<Admin> getAllAdmin()
	{
		return adminService.getAllAdmin();
	}
    
	@GetMapping("{id}")
	public ResponseEntity<Admin>getAdminById(@PathVariable("id") long id) 
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(id), HttpStatus.OK);
	}
	
	@GetMapping("/adminByFirstName/{firstName}")
	public List<Admin> getAdminByFirstName(@PathVariable("firstName")String firstName)
	{
		return adminService.getAdminByFirstName(firstName);
	}
	
	@GetMapping("/adminByLastName/{lastName}")
	public List<Admin> getAdminByLastName(@PathVariable("lastName") String lastName)
	{
		return adminService.getAdminByLastName(lastName);
	}
	
    @GetMapping("/adminByFirstNameAndLastName")
	public List<Admin> getAdminByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return adminService.getAdminByFirstNameAndLastName(firstName, lastName);
	}
	

	@GetMapping("/adminByFirstNameOrLastName")
	public List<Admin> getAdminByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return adminService.getAdminByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/adminFullNameById/{id}")
	public Admin getAdminFullNameById( @PathVariable("id") long id)
	{
		return adminService.getAdminFullNameById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id),HttpStatus.OK);
	}
		
	@GetMapping("/adminInDescOrder")
	public List<Admin> getAdminInDescOrder()
	{
		return adminService.getAdminInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") long id)
	{
		adminService.deleteAdmin(id);
		return new ResponseEntity<String>("Admin record deleted ",HttpStatus.OK);
	}
}	
	
	


