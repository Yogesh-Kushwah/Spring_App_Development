package com.example.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.employeepayroll.repository")  // Ensures Spring finds your repository
public class EmployeePayrollApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollApplication.class, args);
	}
}
