package com.blogapp.start.conrollers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.start.Dto.UserDto;
import com.blogapp.start.entities.User;
import com.blogapp.start.reopsotries.UserReposotries;
import com.blogapp.start.services.UserServices;

@RestController
@RequestMapping(value="/userapi")
public class UserControllers {
	@Autowired
	UserReposotries uerrepo;
	@Autowired
	UserServices userservice;
	@PostMapping(value="/createuser")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userdto){
		UserDto usardto = userservice.createuser(userdto);
		return new ResponseEntity<UserDto>(usardto, HttpStatus.CREATED);
		
	}
	@PutMapping(value="/update/{id}")
	public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userdto,@PathVariable("id") int id){
		                         UserDto updateuser = userservice.updateuser(userdto, id);
		                         return new ResponseEntity<UserDto>(updateuser, HttpStatus.OK); 
		
	}
	@GetMapping(value="/geteee/{id}")
	public ResponseEntity<User> finduserby(@PathVariable int id){
		              User user = uerrepo.findById(id).get();
		              return new ResponseEntity<User>(user, HttpStatus.OK); 
		
	}
	@GetMapping(value="/getalluser")
	public ResponseEntity<List<UserDto>> getalluser() {
		List<UserDto> findalluser = userservice.findalluser();
		return new ResponseEntity<List<UserDto>>(findalluser, HttpStatus.OK); 
		
		
	}}

