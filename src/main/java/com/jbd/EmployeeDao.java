package com.jbd;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {


    public List<Employee> getEmployees() {
        return Stream.of(
                new Employee(1, "Digvijay", "Rana", "ranadigvijay@gmail.com"),
                new Employee(2, "Ramesh", "Lala", "@gmail.com"),
                new Employee(3, "Daniel", "Abraham", "abrahamdaniel@gmail.com"),
                new Employee(4, "Sankalp", "Joshi", "joshisankalp@hotmail.com"))
                .collect(Collectors.toList());
    }
}