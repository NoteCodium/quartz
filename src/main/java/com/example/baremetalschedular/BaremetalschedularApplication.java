package com.example.baremetalschedular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling 
public class BaremetalschedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaremetalschedularApplication.class, args);
	}

}
