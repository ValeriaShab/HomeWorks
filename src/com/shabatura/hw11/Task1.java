package com.shabatura.hw11;

import main.java.com.shabatura.hw10.Aspirant;
import main.java.com.shabatura.hw10.Student;

public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Taras", "Shevchenko", "A", 5);
        Student student1 = new Student("Olena", "Pchilka", "C", 3.2);
        Student student2 = new Student("Taras", "Shevchenko", "A", 5);
        Aspirant aspirant = new Aspirant("Lina", "Kostenko", "B", 5, "World");
        Aspirant aspirant1 = new Aspirant("Lina", "Kostenko", "B", 5, "World");
        Aspirant aspirant2 = new Aspirant("Vasyl", "Stus", "D", 4.9, "Politic");

        boolean compareHashCodeStudent = student.hashCode() == student1.hashCode();
        System.out.println("Compare hashCode (different students) = " + compareHashCodeStudent);
        System.out.println("Compare through equals (different students) = " + student.equals(student1));
        boolean compareHashCodeStudent1 = student.hashCode() == student2.hashCode();
        System.out.println("Compare hashCode (same students) = " + compareHashCodeStudent1);
        System.out.println("Compare through equals (same students) = " + student.equals(student2));
        boolean compareHashCodeAspirant = aspirant.hashCode() == aspirant2.hashCode();
        System.out.println("Compare hashCode (different aspirants) = " + compareHashCodeAspirant);
        System.out.println("Compare through equals (different aspirants) = " + aspirant.equals(aspirant2));
        boolean compareHashCodeAspirant1 = aspirant.hashCode() == aspirant1.hashCode();
        System.out.println("Compare hashCode (same aspirants) = " + compareHashCodeAspirant1);
        System.out.println("Compare through equals (same aspirants) = " + aspirant.equals(aspirant1));

        boolean compareHashCode = student.hashCode() == aspirant.hashCode();
        System.out.println("Compare hashCode = " + compareHashCode);
        System.out.println("Compare through equals = " + student.equals(aspirant));


    }
}
