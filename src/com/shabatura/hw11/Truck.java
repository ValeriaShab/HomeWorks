package com.shabatura.hw11;

public class Truck extends Car{
    private int cargo;

    public Truck(int series, int year, String color, int fuel, int tankSize, int fuelUse) {
        super(series, year, color, fuel, tankSize, fuelUse);
        this.cargo = 0;
    }

    public void loadUnload(int cargo) {
        if (cargo <= 0) {
            System.out.println("Груза нет");
        } else {
            System.out.println("Груз загружен");
        }
    }

    @Override
    public void moving() {
        int distance = 0;
        while (getFuel() > (getFuelUse()* 2)) {
            distance += 30;
            setFuel(getFuel() - (getFuelUse() * 2));
            if (getFuel() < (getFuelUse()* 2)) {
                System.out.println("Машина проехала: " + distance + "км" + "\n");
            }
        }
        System.out.println("Топливо закончилось(");
    }

    public void refuel() {
        fuel = 100;
        System.out.println("Топливо залито " + fuel);
    }
}
