package com.shabatura.hw11;

public class Passenger {
    private String name;
    private String sex;

    public Passenger(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" + "Возраст: " + sex;
    }
}
