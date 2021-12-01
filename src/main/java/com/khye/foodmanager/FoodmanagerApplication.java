package com.khye.foodmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.khye.foodmanager.repository"})
@EntityScan("com.khye.foodmanager")
@EnableJpaRepositories("com.khye.foodmanager.repository")
public class FoodmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodmanagerApplication.class, args);
	}

}
