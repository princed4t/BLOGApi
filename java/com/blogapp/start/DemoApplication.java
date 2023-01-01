package com.blogapp.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blogapp.start.entities.User;
import com.blogapp.start.reopsotries.UserReposotries;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
  @ Autowired
  PasswordEncoder password;
  @Autowired
  UserReposotries urepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u=new User();
		u.setId(1);
		u.setEmail("princedt4@gmail.com");
		u.setName("prince");
		u.setPassword(password.encode("prince"));
		u.setAbout("he is king");
		urepo.save(u);
		
		
	}



   
		
		
	

}
