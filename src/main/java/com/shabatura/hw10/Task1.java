package main.java.com.shabatura.hw10;

public class Task1 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("Taras", "Shevchenko", "A", 5);
        students[1] = new Aspirant("Lina", "Kostenko", "B", 5, "World");
        students[2] = new Student("Olena", "Pchilka", "C", 3.2);
        students[3] = new Aspirant("Vasyl", "Stus", "D", 4.9, "Politic");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getScholarship());
        }
    }
}
