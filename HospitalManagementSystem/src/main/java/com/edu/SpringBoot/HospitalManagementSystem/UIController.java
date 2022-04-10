package com.edu.SpringBoot.HospitalManagementSystem;

import java.util.List;

import javax.management.AttributeNotFoundException;
import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.Doctor;
import com.edu.SpringBoot.HospitalManagementSystem.Entity.Patient;
import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;
import com.edu.SpringBoot.HospitalManagementSystem.Service.DoctorService;
import com.edu.SpringBoot.HospitalManagementSystem.Service.PatientService;




@Controller
public class UIController {
	
	private DoctorService doctorService;
	private PatientService patientService;
	
	
	
@Autowired	
public UIController(DoctorService doctorService, PatientService patientService) {
		super();
		this.doctorService = doctorService;
		this.patientService = patientService;
		
	}

@GetMapping("/addDoctor")
public String proRegistrationForm(Model model) {
	Doctor doctor = new Doctor();
	model.addAttribute("doctor", doctor);
    return "add-doctor";
}

@PostMapping("/saveDoctor")
public String saveDoctor(@Valid  Doctor doctor, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    doctorService.saveDoctor(doctor);
	List<Doctor> doctors =  doctorService.getAllDoctor();
    model.addAttribute("successMessage", "Details are saved successfully");
    getAllDoctor(model);
    }
    return "list-doctor";
    
}

@GetMapping("/getDoctors")
public String getAllDoctor(Model model) {
	
	List<Doctor> doctors =  doctorService.getAllDoctor();
	
	model.addAttribute("doctors", doctors);
	
    return "list-doctor";}
@GetMapping("/updateFormDoctor/{id}")
public String updateFormDoctor(@PathVariable(value="id" )long id,  Model model)
{
	Doctor doctor=doctorService.getDoctorById(id);
	model.addAttribute("doctor",doctor);
	return "update-doctor";
}
	@PostMapping("/updateDoctor/{id}")
	public String updateDoctor(@PathVariable(value="id" )long id, @ModelAttribute Doctor doctor, Model model) {
		doctorService.updateDoctor(doctor, id);
		model.addAttribute("message","record updated successfully");
		getAllDoctor(model);
		return null;
	}

@GetMapping("/deleteDoctor/{id}")
public String deleteDoctor(@PathVariable  long id, Model model)
{
	doctorService.deleteDoctorById(id);
	model.addAttribute("message", "Doctor record deleted successfully");
	getAllDoctor(model);
	return "list-doctor";
}



// Patient

@GetMapping("/Patientregistration")
public String patRegistrationForm(Model model) {
	Patient patient = new Patient();
	model.addAttribute("patient", patient);
    return "Registration";
}

@PostMapping("/savePatient")
public String savePatient(@Valid  Patient patient, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    patientService.savePatient(patient);
	List<Patient> patients =  patientService.getAllPatient();
    model.addAttribute("successMessage", "Details are saved successfully");
    getAllPatient(model);
	}
    return "list-patient";
    
}

@GetMapping("/getPatients")
public String getAllPatient(Model model) {
	
	List<Patient> patients =  patientService.getAllPatient();
	
	model.addAttribute("patients", patients);
	
    return "list-patient";}



@GetMapping("/updateFormPatient/{id}")
public String updateFormPatient(@PathVariable(value="id") long id,Model model)
{
	Patient patient=patientService.getPatientById(id);
	model.addAttribute("patient",patient);
	return "update-patient";
}

@PostMapping("/updatePatient/{id}")
public String updateProduct(@PathVariable(value="id" )long id, @ModelAttribute Patient patient, Model model) {
	patientService.updatePatient(patient, id);
	model.addAttribute("message","record updated successfully");
	getAllPatient(model);
	return null;
}


@GetMapping("/deletePatient/{id}")
public String deletePatient(@PathVariable  long id, Model model)
{
	patientService.deletePatientById(id);
	model.addAttribute("message", "Patient record deleted ");
	getAllPatient(model);
	return "list-patient";
}

}


