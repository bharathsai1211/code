package com.stackroute.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository ;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException, UserNotFoundException {
		Optional<User> u1=userRepository.findById(user.getUserId());
		if(u1.isPresent()){
			throw new UserAlreadyExistsException("User with this Id already exists ");
		}
		userRepository.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserAlreadyExistsException, UserNotFoundException {
		User user=userRepository.findByUserIdAndPassword(userId, password);
		if(user==null){
			throw new UserNotFoundException("User Id and password mismatch");
		}
		return user;
	}
	
}
