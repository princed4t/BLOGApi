package com.blogapp.start.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.start.Dto.PostDto;
import com.blogapp.start.servicesimpl.PostServiceImplementation;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
@RequestMapping(value = "/postapi")
public class PostController {
	@Autowired
	PostServiceImplementation postimpl;

	@PostMapping(value = "/userid/{userid}/categoryid/{categoryid}/post")
	public ResponseEntity<PostDto> craeatepost(@RequestBody PostDto postdto, @PathVariable("userid") int userid,
			@PathVariable("categoryid") int catid) {
		PostDto postdtoo = postimpl.createpost(postdto, userid, catid);
		return new ResponseEntity<PostDto>(postdtoo, HttpStatus.CREATED);

	}

	@PutMapping(value = "/postid/{postid}")
	public ResponseEntity<PostDto> updatepost(@RequestBody PostDto postdto, @PathVariable("postid") int postid) {
		PostDto postdtoo = postimpl.updatepost(postdto, postid);
		return new ResponseEntity<PostDto>(postdtoo, HttpStatus.OK);

	}

	@GetMapping(value = "/postid/{postid}")
	public ResponseEntity<PostDto> getbyid(@PathVariable("postid") int postid) {
		PostDto postdtoo = postimpl.getpost(postid);
		return new ResponseEntity<PostDto>(postdtoo, HttpStatus.OK);

	}
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/findall")
	public ResponseEntity<List<PostDto>> findall(@RequestParam(value="pagenumber",defaultValue = "0",required = false)int pagenumber,
			@RequestParam(value="pagesize",defaultValue = "3",required = false)int pagesize,
			@RequestParam(value="sortby",defaultValue = "asc",required = false) String sortby)
{
		List<PostDto> postdtoo = postimpl.getallpost(pagenumber,pagesize,sortby);
		return new ResponseEntity<List<PostDto>>(postdtoo, HttpStatus.OK);

	}
	
	@GetMapping(value = "/findallpostuser/{id}")
	public ResponseEntity<List<PostDto>> findallpostof1user(@PathVariable("id") int id) {
		List<PostDto> postdtoo = postimpl.getallpostbuuser(id);
		return new ResponseEntity<List<PostDto>>(postdtoo, HttpStatus.OK);

	}
	
	

}
