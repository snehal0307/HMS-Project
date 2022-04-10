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

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Patient;
import com.edu.SpringBoot.HospitalManagementSystem.Service.PatientService;

@RestController
@RequestMapping("/api/patient")

public class PatientController {
	private PatientService patientService;

	public PatientController(PatientService patientService) 
	{
		super();
		this.patientService = patientService;
	}
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) 
	{
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<Patient> getAllPatient()
	{
		return patientService.getAllPatient();
	}
    
	@GetMapping("{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable("id") long id) 
	{
		return new ResponseEntity<Patient>(patientService.getPatientById(id), HttpStatus.OK);
	}
	
	@GetMapping("/patientByFirstName/{firstName}")
	public List<Patient> getPatientByFirstName(@PathVariable("firstName")String firstName)
	{
		return patientService.getPatientByFirstName(firstName);
	}
	
	@GetMapping("/patientByLastName/{lastName}")
	public List<Patient> getPatientByLastName(@PathVariable("lastName") String lastName)
	{
		return patientService.getPatientByLastName(lastName);
	}
	
	@GetMapping("/patientByFirstNameAndLastName")
	public List<Patient> getPatientByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return patientService.getPatientByFirstNameAndLastName(firstName, lastName);
	}
	
    @GetMapping("/patientByFirstNameOrLastName")
	public List<Patient> getPatientByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return patientService.getPatientByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/patientFullNameById/{id}")
	public Patient getPatientFullNameById( @PathVariable("id") long id)
	{
		return patientService.getPatientFullNameById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.updatePatient(patient, id),HttpStatus.OK);
	}
		
	@GetMapping("/patientInDescOrder")
	public List<Patient> getPatientInDescOrder()
	{
		return patientService.getPatientInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") long id)
	{
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Patient record deleted ",HttpStatus.OK);
	}
}	



