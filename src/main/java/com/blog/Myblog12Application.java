package com.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Myblog12Application {

	public static void main(String[] args) {
		SpringApplication.run(Myblog12Application.class, args);
	}
	
	@Bean
	 ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
