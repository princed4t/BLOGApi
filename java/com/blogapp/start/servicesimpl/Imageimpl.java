package com.blogapp.start.servicesimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blogapp.start.services.ImageService;
@Service

public class Imageimpl implements ImageService{

	@Override
	public String imageupload(String image, MultipartFile multipartfile) {
	       String filename = multipartfile.getOriginalFilename();
	       String fullpath=image+File.separator+filename;
	       File f=new File(image);
	       if(!f.exists()) {
	    	   f.mkdir();
	       }
	       
	     try {
			Files.copy(multipartfile.getInputStream(),Paths.get(fullpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		return filename;
	}

}
