package com.jbd.dao;

import java.util.List;

import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;

public interface EmployeeDao {

	List<Employee> getAllEmployees() throws JbdException;

	Employee getEmployeeById(int id) throws JbdException;

}
