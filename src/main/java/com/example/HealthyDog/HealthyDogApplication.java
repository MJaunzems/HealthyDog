package com.example.HealthyDog;

import  com.example.HealthyDog.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan(basePackages = "com.example.HealthyDog")
public class
HealthyDogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthyDogApplication.class, args);
    }

}