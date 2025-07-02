package org.example.extra.streams;

import java.util.List;
import java.util.stream.Collectors;

public class CountEmployeeNamesWithSpecifiedCharacter {

    public static void main(String[] args) {

        List<Employee> list = List.of(
            new Employee("Alice", "HR", "50000"),
            new Employee("Bob", "IT", "60000"),
            new Employee("Charlie", "Finance", "70000"),
            new Employee("David", "IT", "80000"),
            new Employee("Eve", "HR", "55000")
        );

        List<Employee> result = list.stream().filter(emp -> emp.getName().startsWith("A")).toList();

        System.out.println("Employees whose names start with 'A':"+result.size());
        result.forEach(emp -> System.out.println(emp.getName()));
    }

}
