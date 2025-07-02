package org.example.extra.streams.employee;

public class Employee {

    String name;
    String department;
    double salary;
    int age;
    String gender;

    public Employee(String name, String department, double salary, int age, String gender) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
