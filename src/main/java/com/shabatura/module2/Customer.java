package com.shabatura.module2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Customer {
    int id;
    String email;
    int age;

    @Override
    public String toString() {
        return "Customer (" + "id= " + id + ", email= " + email + ", age= " + age + ')';
    }
}
