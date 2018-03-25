package com.maksymmikitiuk.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class UniversityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
		System.err.println("\n======================================= APPLICATION STARTED =======================================");
	}
}
