package com.restro.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restro.assignment.util.Constants;

@SpringBootApplication

public class SearchApplication {

	
	private static final Logger log = LoggerFactory.getLogger(SearchApplication.class);

	public static void main(String[] args) {
		log.info(Constants.APPLICATION_STARTED);
		SpringApplication.run(SearchApplication.class, args);
	}

	
}
