package com.example.democrudsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(
		basePackages = {
				"com.example.demospringboot.controller"
})
@EntityScan("com.example.demospringboot.Entity")
@EnableJpaRepositories("com.example.demospringboot.repository")

public class DemocrudsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudsbApplication.class, args);
		System.out.println("hello");
	}

}
