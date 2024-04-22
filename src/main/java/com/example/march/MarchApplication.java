package com.example.march;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.example.march", "service","repository"})
public class MarchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarchApplication.class, args);
	}
	
	//Method to be implement:
	/*
	 * Get
	 * Post
	 * Put
	 * Patch
	 * Delete
	 * Head-postman
	 * Options
	 * Trace
	 * connect
	 * purge
	 * lock
	 * unlock
	 * mkcol
	 * copy
	 */

}
