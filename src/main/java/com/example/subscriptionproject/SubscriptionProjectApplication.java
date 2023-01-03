package com.example.subscriptionproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SubscriptionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionProjectApplication.class, args);
	}

}
