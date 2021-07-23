package com.stackroute.UserRegistrationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.UserRegistrationService.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
