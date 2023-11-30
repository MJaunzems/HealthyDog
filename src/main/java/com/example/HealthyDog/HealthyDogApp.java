package com.example.HealthyDog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.HealthyDog")
public class HealthyDogApp {
    public static void main(String[] args) {
        SpringApplication.run(HealthyDogApp.class, args);

        System.out.println("hiiiii");
    }
}
