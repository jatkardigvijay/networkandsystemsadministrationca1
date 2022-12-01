package com.jbd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NetworkAndSystemsAdministrationApplication {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping("/home")
	public String getMessage() {

		return "Welcome to CI/CD using AWS code pipeline - NSA continuous pipeline 1";
	}

	@GetMapping("/api/v1")
	public List<Employee> getAllEmployess() {
		return employeeDao.getEmployees();
	}

	public static void main(String[] args) {
		SpringApplication.run(NetworkAndSystemsAdministrationApplication.class, args);

	}

}
