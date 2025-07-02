package org.example.extra.streams.employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestSalaryInEachDepartment {

    public static void main(String[] args) {
        Employee[] list = {
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F"),
                new Employee("Frank", "IT", 75000, 29, "M"),
        };

        Map<String, Optional<Employee>> result = Stream.of(list).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        result.forEach((department, highestPaidEmployee) -> {
            if (highestPaidEmployee.isPresent()) {
                System.out.println("Department: " + department + ", Highest Salary Employee: " + highestPaidEmployee.get().getName() + " with Salary: " + highestPaidEmployee.get().getSalary());
            } else {
                System.out.println("Department: " + department + " has no employees.");
            }
        });
    }

}
