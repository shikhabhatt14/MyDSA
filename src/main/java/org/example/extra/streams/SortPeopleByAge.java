package org.example.extra.streams;

import java.util.Comparator;
import java.util.List;

public class SortPeopleByAge {

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Ajay", 22),
                                      new Person("Vijay", 25),
                                      new Person("Sujay", 20),
                                      new Person("Sanjay", 30),
                                      new Person("Dhananjay", 28));

        System.out.println("Sorting people by age in ascending order:");
        people.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).forEach(p -> System.out.println(p.getName()+ " - "+ p.getAge()));

        System.out.println("\nSorting people by age in descending order:");
        people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).forEach(p -> System.out.println(p.getName()+ " - "+ p.getAge()));
    }

}
