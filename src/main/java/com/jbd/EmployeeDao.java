package com.jbd;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {


    public List<Employee> getEmployees() {
        return Stream.of(
                new Employee(1, "Digvijay", "Jatkar", "ranadigvijay@gmail.com"),
                new Employee(2, "Ramesh", "Joshi", "joshiramesh@gmail.com"),
                new Employee(3, "Devi", "Prasad", "prasaddevi@gmail.com"),
                new Employee(4, "Martand", "Damdhere", "martanddamdhere@hotmail.com"))
                .collect(Collectors.toList());
    }
}