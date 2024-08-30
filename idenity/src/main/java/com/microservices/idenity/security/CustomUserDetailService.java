package com.microservices.idenity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.microservices.idenity.repository.UserRepo;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.microservices.idenity.entity.User u  = userRepo.findByUserName(username);
		UserDetails user = User.builder().username(u.getUserName()).password(u.getPassword()).build();
		return  user;
	}

}
