package com.jbd.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.jbd.dao.EmployeeDao;
import com.jbd.entity.Employee;
import com.jbd.exception.JbdException;
import com.jbd.utils.Queries;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class.getName());

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Employee> getAllEmployees() throws JbdException {

		List<Employee> employeeList = new ArrayList<Employee>();

		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.GET_ALL_EMPLOYEES);

			logger.info("Executing query : " + Queries.GET_ALL_EMPLOYEES);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"));

				employeeList.add(employee);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new JbdException("Error executing stored procedure", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) throws JbdException {

		Employee employee = null;

		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.GET_EMPLOYEE_BY_ID);

			logger.info("Executing query : " + Queries.GET_EMPLOYEE_BY_ID);
			
			ps.setObject(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				employee = new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new JbdException("Error executing query" + Queries.GET_EMPLOYEE_BY_ID,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return employee;
	}

}
