package com.example.katatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class KatatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KatatestApplication.class, args);
	}

}
