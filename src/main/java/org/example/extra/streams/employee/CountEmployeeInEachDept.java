package org.example.extra.streams.employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEmployeeInEachDept {

    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F")
        );

        list.stream().collect(Collectors.groupingBy(Employee :: getDepartment))
                .entrySet().stream()
                .forEach(key -> {
                    String department = key.getKey();
                    int count = key.getValue().size();
                    System.out.println("Department: " + department + ", Count: " + count);
                });

        //Alternate way(easier one)
        Map<String, Long> deptCountMap = list.stream()
                                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }


}
