package com.example.HealthyDog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class
HealthyDogApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthyDogApplication.class, args);}


}
