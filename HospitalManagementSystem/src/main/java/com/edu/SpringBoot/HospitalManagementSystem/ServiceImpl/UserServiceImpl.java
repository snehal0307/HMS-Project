package com.edu.SpringBoot.HospitalManagementSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;
import com.edu.SpringBoot.HospitalManagementSystem.Exception.ResourceNotFound;
import com.edu.SpringBoot.HospitalManagementSystem.Repository.UserRepository;
import com.edu.SpringBoot.HospitalManagementSystem.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
		
	}


	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
          
			throw new ResourceNotFound("User","Id",id);
		}
		
	}


	@Override
	public User updateUser(User user, long id) {
		User use = new User();
	 try {
		   use = userRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("User","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 use.setUserName(user.getUserName());
	  use.setPassword(user.getPassword());
	  use.setActive(user.isActive());
	  use.setRoles(user.isRoles());
	  
	 userRepository.save(use);
	return use;
	}


	@Override
	public Optional<User> findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
