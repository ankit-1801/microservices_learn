package com.microservices.idenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.idenity.entity.User;
import com.microservices.idenity.security.JwtHelper;
import com.microservices.idenity.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
    
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager manager;
	
	@PostMapping("/register")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
    }
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		String token;
		try {
		manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new BadCredentialsException("Bad Credentials!!");
		}
		token = userService.generateToken(user.getUserName());
		return token;
    }
	
	@GetMapping("/hi")
	public User get() {
		return new User("ram","ram");
    }
	 
	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Bad Credential!!!";
	}
}
