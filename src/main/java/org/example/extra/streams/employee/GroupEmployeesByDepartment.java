package org.example.extra.streams.employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByDepartment {

    public static void main(String[] args) {

        List<Employee> list = List.of(
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F")
        );

        Map<String, List<Employee>> result = list.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));

        System.out.println("Employees grouped by department:");

        result.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(emp ->
                    System.out.println(" - " + emp.getName() + " (" + emp.getSalary() + ")"));
        });
    }

}
