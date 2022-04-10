
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
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;
import com.edu.SpringBoot.HospitalManagementSystem.Service.UserService;
@RestController
@RequestMapping("/api/hospitaluser")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
    @GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	@GetMapping("{id}")
	public ResponseEntity<User>getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
		
	}
}