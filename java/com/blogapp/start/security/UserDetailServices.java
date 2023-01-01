package com.blogapp.start.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blogapp.start.entities.User;
import com.blogapp.start.reopsotries.UserReposotries;
@Component
public class UserDetailServices  implements UserDetailsService{

	@Autowired
	UserReposotries urepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = urepo.findByEmail(username).get();
		return user;
	}

}
