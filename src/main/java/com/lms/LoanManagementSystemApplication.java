package com.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LoanManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemApplication.class, args);
	}

}
