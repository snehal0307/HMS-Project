package com.edu.SpringBoot.HospitalManagementSystem.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;
import com.edu.SpringBoot.HospitalManagementSystem.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found "+ userName));
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}

}
