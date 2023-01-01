package com.blogapp.start.services;

import java.util.List;

import com.blogapp.start.Dto.Categorydto;

public interface Categoryinter {
	//add
	public Categorydto createcategory(Categorydto cd);
	//get
	public Categorydto getcategorydto(int id);
	//getall
	public List<Categorydto> categorydtoo();
	//update
	public Categorydto update(Categorydto catdto,int id);
	 //delete
	public void deletebyid(int id);
	
	
	

}
