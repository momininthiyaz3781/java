package day24;
//Task 4: Lambda Expressions Implement a Comparator for a Person class using a lambda expression, and sort a list of Person objects by their age..


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class PersonSorting {
    public static void main(String[] args) {
        // Step 1: Define the Person class
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        // Step 2: Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Step 3: Sort the list using a lambda expression for the Comparator
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print the sorted list
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

