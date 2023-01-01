package com.blogapp.start.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blogapp.start.Dto.ApiResponse;
import com.blogapp.start.servicesimpl.Imageimpl;

@RestController

@RequestMapping(value="/imag")
public class ImageController {
	 @Autowired
	 Imageimpl imageimpl;
@Value("${project.image}")	  
private	String path;
	
	@PostMapping(value= "/upload")
	public ResponseEntity<ApiResponse> uploadimage(@RequestParam("images") MultipartFile file){
		String imageupload = imageimpl.imageupload(path, file);
		ApiResponse api=new ApiResponse();
		api.setError(imageupload);
		api.setProblem("succcess");
		return new ResponseEntity<ApiResponse>(api,HttpStatus.OK);
	}
	

}
