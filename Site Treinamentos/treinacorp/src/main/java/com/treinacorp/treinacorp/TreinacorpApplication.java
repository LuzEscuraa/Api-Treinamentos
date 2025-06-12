package com.treinacorp.treinacorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.treinacorp.treinacorp.repo")
public class TreinacorpApplication {

	public static void main(String[] args) {

		SpringApplication.run(TreinacorpApplication.class, args);
	}

}
