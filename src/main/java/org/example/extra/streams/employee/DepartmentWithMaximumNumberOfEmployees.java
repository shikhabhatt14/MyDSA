package org.example.extra.streams.employee;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DepartmentWithMaximumNumberOfEmployees {

    public static void main(String[] args) {
        // Sample data
        Employee[] list = {
            new Employee("Alice", "HR", 50000, 30, "F"),
            new Employee("Bob", "IT", 60000, 35, "M"),
            new Employee("Charlie", "Finance", 70000, 32, "M"),
            new Employee("David", "IT", 80000, 33, "M"),
            new Employee("Eve", "HR", 55000, 34, "F"),
            new Employee("Frank", "IT", 75000, 29, "M"),
        };

        Map.Entry<String, Long> dept = Stream.of(list).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Department with maximum number of employees: " + dept.getKey() + " with count: " + dept.getValue());
    }

}
