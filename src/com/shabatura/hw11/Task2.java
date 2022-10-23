package com.shabatura.hw11;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("_____МАШИНА_____");
        Car car1 = new Car(12, 2021, "Green", 95, 100, 10);
        car1.statistic();
        car1.moving();
        System.out.println("______ЛЮДИ______");
        PassengerCar passengerCar1 = new PassengerCar(1, 2021, "Gray", 50, 100, 15);
        Passenger passenger1 = new Passenger("Valeria", "women");
        Passenger passenger2 = new Passenger("Viktoria", "women");
        Passenger passenger3 = new Passenger("David", "men");
        passengerCar1.loadingPassengers(new Passenger[]{passenger1, passenger2, passenger3});
        passengerCar1.showPassengers();
        System.out.println("_____МАШИНА ЕДЕТ И ЗАПРАВЛЯЕТСЯ_____");
        passengerCar1.moving();
        passengerCar1.refuel();
        System.out.println("_____ГРУЗОВИК______");
        Truck truck = new Truck(1, 2021, "White", 70, 100, 20);
        truck.loadUnload(30);
        truck.loadUnload(0);
        truck.loadUnload(-5);
        truck.moving();
        truck.refuel();
    }
}
