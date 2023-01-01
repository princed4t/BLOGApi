package com.blogapp.start.config4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Configuration {
    @Bean
	public ModelMapper getmodelmapper() {
		return new ModelMapper();
	}
	
	
}
