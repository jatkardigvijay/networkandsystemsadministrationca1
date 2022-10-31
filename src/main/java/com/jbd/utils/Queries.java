package com.jbd.utils;

public class Queries {

	public static final String GET_ALL_EMPLOYEES = "select * from employee";
	public static final String GET_EMPLOYEE_BY_ID = "select * from employee where id = ?";
	public static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where id = ?";
}
