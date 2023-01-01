package com.blogapp.start.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Categorydto {
	private String catid;
	@NotEmpty
	@Min(value =6,message="must be equal 6 char")
	private String details;
	private String title;
	

}
