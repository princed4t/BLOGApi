package com.blogapp.start.reopsotries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.start.entities.User;

public interface UserReposotries extends JpaRepository<User, Integer> {
Optional<User> findByEmail(String email);
	
	
	
	

}
