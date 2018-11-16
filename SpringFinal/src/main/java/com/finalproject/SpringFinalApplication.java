package com.finalproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.finalproject.repository")
@SpringBootApplication(scanBasePackages= {"com.finalproject.controller","com.finalproject.model","com.finalproject.service","com.finalproject.repository"})
@EntityScan( basePackages="com.finalproject.model")
public class SpringFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFinalApplication.class, args);
	}
}
