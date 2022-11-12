package main.java.com.shabatura.module2;

import java.util.Random;

public class PersonService {
    public static Customer generateCustomer() {
        Random random = new Random();
        int id = random.nextInt(1, 50000);
        String email = random.nextInt(111111, 9999999) + "@gmail.com";
        int age = random.nextInt(12, 100);
        return new Customer(id, email, age);
    }
}
