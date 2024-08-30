package com.microservices.idenity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.idenity.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	 User findByUserName(String userName);

}
