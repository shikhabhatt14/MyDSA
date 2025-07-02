package org.example.extra.streams.employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageAgePerGender {

    public static void main(String[] args) {

        List<Employee> list = List.of(
                new Employee("Alice", "HR", 50000, 30, "F"),
                new Employee("Bob", "IT", 60000, 35, "M"),
                new Employee("Charlie", "Finance", 70000, 32, "M"),
                new Employee("David", "IT", 80000, 33, "M"),
                new Employee("Eve", "HR", 55000, 34, "F")
        );

        Map<String,Double> avgAge = list.stream().collect(Collectors.groupingBy(
                                        Employee::getGender, Collectors.averagingInt(Employee::getAge)
        ));

        avgAge.forEach((key, count) -> System.out.println(key + " : " + count));
    }

}
