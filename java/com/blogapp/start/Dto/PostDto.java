package com.blogapp.start.Dto;




import com.blogapp.start.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PostDto {

	private int postid;
	private String title;
	private  String content;
	private String image;
    
	private UserDto user;
    
	private Categorydto category;
	
	

}