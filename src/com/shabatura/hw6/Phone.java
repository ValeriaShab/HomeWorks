package com.shabatura.hw6;

public class Phone {
    private int number;
    private String model;
    private int weight;

    public Phone(int number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {

    }

    public static void printInfo(Phone phone) {
        System.out.println("Информация о телефоне: " + phone.number + " " + phone.model + " " + phone.weight);
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void getNumber() {
        System.out.println(this.number);
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone(1224, "ten", 125);
        Phone phone2 = new Phone(3087, "eleven");
        Phone phone3 = new Phone();
        printInfo(phone1);
        printInfo(phone2);
        printInfo(phone3);
        phone1.receiveCall("Татьяна");
        phone1.getNumber();
        phone2.receiveCall("Александр");
        phone2.getNumber();
        phone3.receiveCall("Алеся");
        phone3.getNumber();
    }
}
