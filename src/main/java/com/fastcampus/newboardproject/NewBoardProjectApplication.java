package com.fastcampus.newboardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class NewBoardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewBoardProjectApplication.class, args);
	}

}
