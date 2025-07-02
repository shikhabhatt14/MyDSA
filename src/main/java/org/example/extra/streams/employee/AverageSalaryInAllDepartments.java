package org.example.extra.streams.employee;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AverageSalaryInAllDepartments {

    public static void main(String[] args) {

        Employee[] list = {
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F"),
                new Employee("Frank", "IT", 75000, 29, "M"),
        };

        Map<String,Double> sal = Stream.of(list).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary in each department:");
        sal.forEach((department, averageSalary) ->
            System.out.println("Department: " + department + ", Average Salary: " + averageSalary)
        );
    }

}
