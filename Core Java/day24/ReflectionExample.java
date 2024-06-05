package day24;
//Task 3: Reflection API Use reflection to inspect a class's methods, fields, and constructors, and modify the access level of a private field, setting its value during runtime 

 

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Assuming we have a class named ExampleClass
            Class<?> clazz = ExampleClass.class;

            // Inspecting methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            // Inspecting fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            // Inspecting constructors
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Modifying the access level of a private field and setting its value
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true);
            ExampleClass instance = new ExampleClass();
            privateField.set(instance, "New Value");
            System.out.println("\nModified Private Field Value: " + privateField.get(instance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExampleClass {
    @SuppressWarnings("unused")
	private String privateField = "Initial Value";

    public ExampleClass() {
    }

    public void exampleMethod() {
        System.out.println("Example Method");
    }
}
