package com.blogapp.start.services;

import org.springframework.boot.autoconfigure.web.reactive.ReactiveMultipartProperties;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	public String imageupload(String image,MultipartFile multipartfile);
	

}
