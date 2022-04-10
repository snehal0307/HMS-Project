package com.edu.SpringBoot.HospitalManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import com.edu.SpringBoot.HospitalManagementSystem.Entity.User;

public interface UserService {
   public Optional<User> findUserByUserName(String userName);

User saveUser(User user);

List<User> getAllUser();

User getUserById(long id);

User updateUser(User user, long id);

//public void deleteUser(long id);


   
}
