package com.stackroute.userauthetication.serviceTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.stackroute.userauthentication.model.UserDao;
import com.stackroute.userauthentication.repository.UserRepository;
import com.stackroute.userauthentication.service.JwtUserDetailsService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@Mock
	private UserRepository repo;
	@InjectMocks
	private JwtUserDetailsService service;
	
	private PasswordEncoder bcryptEncoder;
//	@Test
//	public void add() {
//		UserDto user=new UserDto();
//		user.setEmail("b@gamil");
//		user.setPassword("1232dd");
//		user.setUsername("sai");
//		UserDao newUser = new UserDao();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setEmail(user.getEmail());
//		when(service.save(user)).thenReturn(newUser);
//		when(repo.save(newUser)).thenReturn(newUser);
//		service.save(user);
//		verify(repo, times(1)).save(newUser);
//	}
	@Test
	public void loadByName()
	{
		UserDao user=new UserDao();
		user.setEmail("b@gamil");
		user.setPassword("1232dd");
		user.setUsername("c");
		when(repo.findByUsername("c")).thenReturn(user);
		service.loadUserByUsername("c");
		verify(repo,times(1)).findByUsername("c");
	}

}
