package org.example.extra.streams.employee;

import java.util.Comparator;
import java.util.stream.Stream;

public class EmployeeWithSecondLowestSalary {

    public static void main(String[] args) {
        Employee[] list = {
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F"),
                new Employee("Frank", "IT", 75000, 29, "M"),
        };

        Employee secondLowest = Stream.of(list).sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();

        System.out.println("Employee with the second lowest salary: " + secondLowest.getName() + " with Salary: " + secondLowest.getSalary());
    }

}
