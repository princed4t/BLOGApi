package com.blogapp.start.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogapp.start.Dto.Categorydto;
import com.blogapp.start.entities.Category;
import com.blogapp.start.exceptions.ResourceNotFoundException;
import com.blogapp.start.reopsotries.Categoryrepostries;
import com.blogapp.start.services.Categoryinter;
@Service
@Transactional
public class Categoryserviceimplementation implements Categoryinter {
   @Autowired
   Categoryrepostries catrep;
   @Autowired
   ModelMapper modelmap;
	
	
	@Override
	public Categorydto createcategory(Categorydto cd) {
		 Category map = modelmap.map(cd, Category.class);
		
		Category cat = catrep.save(map);
		Categorydto map2 = modelmap.map(cat, Categorydto.class);
		 
		
		
		return map2;
	}

	@Override
	public Categorydto getcategorydto(int id) {
	        Category cat = catrep.findById(id).orElseThrow(()->new ResourceNotFoundException("please valid"));
		    Categorydto map = modelmap.map(cat,Categorydto.class);
	        return map;
	}

	@Override
	public List<Categorydto> categorydtoo() {
		List<Category> categories = catrep.findAll();
		List<Categorydto> collect = categories.stream().map(category->modelmap.map(category,Categorydto.class)).collect(Collectors.toList());
		                                                                                                                     
		return collect;
	}

	@Override
	public Categorydto update(Categorydto catdto,int id) {
		               Category caty = modelmap.map(catdto,Category.class); 
		Category cat = catrep.findById(id).orElseThrow(()->new ResourceNotFoundException("please valid"));
		cat.setDetails(caty.getDetails());
	    cat.setTitle(caty.getTitle());
	    catrep.save(cat);
	    return modelmap.map(cat,Categorydto.class);
		
	}

	@Override
	public void deletebyid(int id) {
		Category cat = catrep.findById(id).orElseThrow(()->new ResourceNotFoundException("please valid"));
		catrep.delete(cat);
		
		
	}

}
