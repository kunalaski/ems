package com.example.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
