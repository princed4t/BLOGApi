package com.blogapp.start.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Role {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	private String role;
	@ManyToMany
	@JoinTable(name="rolestable",
	joinColumns = @JoinColumn(referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName ="id" ))
	private Set<User> user=new HashSet<>();
	
}
