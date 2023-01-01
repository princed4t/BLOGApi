package com.blogapp.start.services;

import java.util.List;

import com.blogapp.start.Dto.UserDto;
import com.blogapp.start.entities.User;

public interface UserServices {
	
	UserDto createuser(UserDto udto);
public	UserDto finduser(int id);
public	 UserDto updateuser(UserDto user,int id);
  public void deleteuser(int id);
  List<UserDto> findalluser();
	
	
	

}
