package com.microservices.idenity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class User {
	 
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public User() {
	}
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
     Integer id;
     String userName;
     String password;
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		this.password = encode;
	}
}
