package com.blogapp.start.config4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blogapp.start.security.Authenticationentrypoint;
import com.blogapp.start.security.SecurityFillter;
import com.blogapp.start.security.UserDetailServices;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Springsecurityconfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServices uds;
	@Autowired
	private SecurityFillter securityfilter;
	@Autowired
	private Authenticationentrypoint authenticationentrypoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(uds).passwordEncoder(this.passwordencoder());

	}

	@Bean
	public PasswordEncoder passwordencoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("/m1/auth/login")
		.permitAll()
		.antMatchers(HttpMethod.GET)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()	
.authenticationEntryPoint(this.authenticationentrypoint)
.and()
.sessionManagement()
.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(this.securityfilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

}
