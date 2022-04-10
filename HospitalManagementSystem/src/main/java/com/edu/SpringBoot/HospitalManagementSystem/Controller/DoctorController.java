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

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Doctor;
import com.edu.SpringBoot.HospitalManagementSystem.Service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) 
	{
		super();
		this.doctorService = doctorService;
	}
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) 
	{
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<Doctor> getAllDoctor()
	{
		return doctorService.getAllDoctor();
	}
    
	@GetMapping("{id}")
	public ResponseEntity<Doctor>getDoctorById(@PathVariable("id") long id) 
	{
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(id), HttpStatus.OK);
	}
	
	@GetMapping("/doctorByFirstName/{firstName}")
	public List<Doctor> getDoctorByFirstName(@PathVariable("firstName")String firstName)
	{
		return doctorService.getDoctorByFirstName(firstName);
	}
	
	@GetMapping("/doctorByLastName/{lastName}")
	public List<Doctor> getDoctorByLastName(@PathVariable("lastName") String lastName)
	{
		return doctorService.getDoctorByLastName(lastName);
	}
	
	@GetMapping("/doctorByFirstNameAndLastName")
	public List<Doctor> getDoctorByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return doctorService.getDoctorByFirstNameAndLastName(firstName, lastName);
	}
	
    @GetMapping("/doctorByFirstNameOrLastName")
	public List<Doctor> getDoctorByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return doctorService.getDoctorByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/doctorFullNameById/{id}")
	public Doctor getDoctorFullNameById( @PathVariable("id") long id)
	{
		return doctorService.getDoctorFullNameById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, id),HttpStatus.OK);
	}
		
	@GetMapping("/employeeInDescOrder")
	public List<Doctor> getDoctorInDescOrder()
	{
		return doctorService.getDoctorInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") long id)
	{
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor record deleted ",HttpStatus.OK);
	}
}	
	