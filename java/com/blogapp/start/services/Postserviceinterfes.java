package com.blogapp.start.services;

import java.util.List;

import com.blogapp.start.Dto.Categorydto;
import com.blogapp.start.Dto.PostDto;
import com.blogapp.start.Dto.UserDto;


public interface Postserviceinterfes {
	//createpost
	public PostDto createpost(PostDto postdto,int userid,int categoryid);
	//UPDATEPOST
	public PostDto updatepost(PostDto postdto,int id);
	//GETPOST
	public PostDto getpost(int postid);
	//GetallPost
	public List<PostDto> getallpost(int pagenumber,int pagesize,String sortvalue);
	//deletepost
	public void deletepostbyid(Integer id);
	//GETALLPOSTBYUSER..AS WE DO ONE O MANY RELATIONSHIP BVETWEEN O ENTITIES
	
	public List<PostDto> getallpostbuuser(int userid);
	//GET ALL POST BY CATEGORY
	public List<PostDto> getallpostbYCATEGORY(Categorydto cat);
	
	
	
	
	

}
