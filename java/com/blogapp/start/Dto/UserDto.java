package com.blogapp.start.Dto;


import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.blogapp.start.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	
	private int id;
	@NotEmpty
//	@Min(value =6,message="must be equal 6 char")
	private String name;
	@Email
	private String email;
	private String password;
	//@Min(value=5,message = "plz provide more input")
	private String about;
	
//	private List<PostDto> postdto;

}
