package com.jbd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.config.Response;
import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;
import com.jbd.service.EmployeeService;

@RestController
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/api/v1")
	public ResponseEntity<Response> getAllEmployees() throws JbdException {

		List<Employee> employeeList = employeeService.getAllEmployees();

		if (employeeList == null || employeeList.isEmpty()) {

			logger.info("No data found or list is empty");
			throw new JbdException("No data found", HttpStatus.OK, employeeList);
		} else {

			logger.info("received employee list with size : " + employeeList.size());
			return new ResponseEntity<Response>(new Response("success", employeeList, null), HttpStatus.OK);
		}
	}
}
