package com.stackroute.UserRegistrationService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class User {


	/*
	 * Defining the columns in the table
	 * Marking username of type string as Primary Key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	private String password;
	
	/*
	 * Creating Getters and Setters
	*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * overriding the toString Method
	*/
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
		
}
