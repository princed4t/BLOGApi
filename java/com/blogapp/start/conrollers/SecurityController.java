package com.blogapp.start.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.start.Dto.Jwtrequest;
import com.blogapp.start.security.JwtAuthResponse;
import com.blogapp.start.security.TokenHelper;
import com.blogapp.start.security.UserDetailServices;

@RestController
@RequestMapping("m1/auth")
public class SecurityController {
	@Autowired
	TokenHelper tokenhelper;
	@Autowired
	private UserDetailServices userdetailservices;
	
	@Autowired
private	AuthenticationManager authenticationManager;
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> m1(@RequestBody Jwtrequest request){
		
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails user = this.userdetailservices.loadUserByUsername(request.getUsername());
		String token= this.tokenhelper.generateToken(user);
		JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
		jwtAuthResponse.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse,HttpStatus.OK);
		
		
		}

	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	}

}
