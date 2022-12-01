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
                new Employee(2, "Devi", "Prasad", "prsaddevi@gmail.com"),
                new Employee(3, "Ankan", "Joshi", "joshiankan@gmail.com"),
                new Employee(4, "Devi", "yadav", "prsadyadav@gmail.com"),
                new Employee(5, "Ramesh", "Lala", "lalaramesh@gmail.com"))

                .collect(Collectors.toList());
    }
}