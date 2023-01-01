package com.blogapp.start.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.start.Dto.ApiResponse;
import com.blogapp.start.Dto.Categorydto;
import com.blogapp.start.servicesimpl.Categoryserviceimplementation;

@RestController
@RequestMapping(value="/createapi")
public class CategoryController {
	
	@Autowired
	Categoryserviceimplementation csimp;
	
	@PostMapping(value="/create")
	public ResponseEntity<Categorydto> createcategorydto(@RequestBody Categorydto catdto ){
		
		
		Categorydto Categorydto = csimp.createcategory(catdto);
	     ResponseEntity<Categorydto> catdtos=new ResponseEntity<Categorydto>(Categorydto,HttpStatus.OK);
	     return catdtos;
		
		
		
	}
	@GetMapping(value="/getcat/{id}")
	public ResponseEntity<Categorydto> getcatdto(@PathVariable("id") int id){
		Categorydto categorydto = csimp.getcategorydto(id);
		ResponseEntity<Categorydto> responseEntity = new ResponseEntity<Categorydto>(categorydto,HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping(value="/updatecat/{id}")
	public ResponseEntity<Categorydto> updatecatdto(@RequestBody Categorydto catdo,@PathVariable("id") int id){
		 Categorydto update = csimp.update(catdo, id);
		 return new ResponseEntity<Categorydto>(update,HttpStatus.OK);
		 }
	
	@GetMapping(value="/getall")
	public ResponseEntity<List<Categorydto>> findall(){
		List<Categorydto> categorydtoo = csimp.categorydtoo();
		return new ResponseEntity<List<Categorydto>>(categorydtoo,HttpStatus.OK);
	}
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<ApiResponse> deletebyid(@PathVariable int id){
		csimp.deletebyid(id);
		ApiResponse ai=new ApiResponse();
		ai.setProblem("deleted");
		ai.setError("successfully");
		return new ResponseEntity<ApiResponse>(ai,HttpStatus.BAD_REQUEST);
	}
	
	

}
