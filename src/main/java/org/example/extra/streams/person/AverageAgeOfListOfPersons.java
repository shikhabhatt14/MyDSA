package org.example.extra.streams.person;

import java.util.ArrayList;
import java.util.List;

public class AverageAgeOfListOfPersons {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Charlie", 35));
        persons.add(new Person("Diana", 28));
        persons.add(new Person("Ethan", 40));

        double averageAge = persons.stream().mapToInt(Person::getAge).average()
                .orElse(0); // Default to 0 if the list is empty
        System.out.println("Average age of persons: " + averageAge);

        double avgAge = persons.stream().mapToInt(person -> person.getAge()).average()
                .orElse(0); // Default to 0 if the list is empty
        System.out.println("Average age of persons using lambda: " + avgAge);
    }

}
