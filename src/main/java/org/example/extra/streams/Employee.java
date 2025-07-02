package org.example.extra.streams;

public class Employee {

    String name;
    String department;
    String salary;

    public Employee(String name, String department, String salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getSalary() {
        return salary;
    }

}
