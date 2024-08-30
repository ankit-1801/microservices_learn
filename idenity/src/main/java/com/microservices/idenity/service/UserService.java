package com.microservices.idenity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservices.idenity.entity.User;
import com.microservices.idenity.repository.UserRepo;
import com.microservices.idenity.security.JwtHelper;

import lombok.Setter;

@Service
public class UserService {
	
	@Autowired
	JwtHelper jwtHelper;
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	public void saveUser(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
	    repo.save(u);	
	}
	
	public String generateToken(String username) {
	        return jwtHelper.generateToken(username);
	}
	
	
}
