package com.jbd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/employee")
public class NetworkAndSystemsAdministrationApplication {
	
	@Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/api/v1")
    public List<Employee> fetchOrders() {
        return employeeDao.getEmployees();
    }

	public static void main(String[] args) {
		SpringApplication.run(NetworkAndSystemsAdministrationApplication.class, args);

	}

}
