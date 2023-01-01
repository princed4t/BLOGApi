package com.blogapp.start.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	private String title;
	private  String content;
	private String image;
	
	  @ManyToOne
	  
	  @JoinColumn(name="userinfo",referencedColumnName = "id") 
	  private User user;
	 
	 @ManyToOne
	  
	  @JoinColumn(name="categoryinfo",referencedColumnName = "catid") private
	  Category category;
	 
	
	

}
