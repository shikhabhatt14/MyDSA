package org.example.extra.streams.employee;

import java.util.List;

public class TotalCountOfEmployees {

    public static void main(String[] args) {

        List<Employee> list = List.of(
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F")
        );

        long count = list.stream().count();

        System.out.println("Total number of employees: " + count);

    }

}
