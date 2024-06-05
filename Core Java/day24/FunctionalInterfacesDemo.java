package day24;
//Task 5: Functional Interfaces Create a method that accepts functions as parameters using Predicate, Function, Consumer, and Supplier interfaces to operate on a Person object.

 

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {

   public static void main(String[] args) {
       // Step 2: Create a Person object
       Person person = new Person("Alice", 30);

       // Step 3: Use functional interfaces

       // Predicate: Check if the person's age is greater than 25
       Predicate<Person> isOlderThan25 = p -> p.getAge() > 25;
       System.out.println("Is older than 25: " + evaluatePredicate(person, isOlderThan25));

       // Function: Get the person's name
       Function<Person, String> getNameFunction = Person::getName;
       System.out.println("Name: " + applyFunction(person, getNameFunction));

       // Consumer: Print the person's details
       Consumer<Person> printPersonConsumer = System.out::println;
       acceptConsumer(person, printPersonConsumer);

       // Supplier: Create a new person
       Supplier<Person> newPersonSupplier = () -> new Person("Bob", 25);
       Person newPerson = getFromSupplier(newPersonSupplier);
       System.out.println("New Person: " + newPerson);
   }

   // Method to evaluate Predicate
   public static boolean evaluatePredicate(Person person, Predicate<Person> predicate) {
       return predicate.test(person);
   }

   // Method to apply Function
   public static <R> R applyFunction(Person person, Function<Person, R> function) {
       return function.apply(person);
   }

   // Method to accept Consumer
   public static void acceptConsumer(Person person, Consumer<Person> consumer) {
       consumer.accept(person);
   }

   // Method to get from Supplier
   public static Person getFromSupplier(Supplier<Person> supplier) {
       return supplier.get();
   }
}

class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
       this.name = name;
       this.age = age;
   }

   public String getName() {
       return name;
   }

   public int getAge() {
       return age;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setAge(int age) {
       this.age = age;
   }

   @Override
   public String toString() {
       return name + " (" + age + ")";
   }
}