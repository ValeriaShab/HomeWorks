package com.shabatura.hw11;

public class Car implements Recovery{
    protected int series;
    protected int year;
    protected String color;
    protected int tankSize;
    protected int fuel;
    protected int fuelUse;

    public void moving() {
        int distance = 0;
        while (getFuel() > getFuelUse()) {
            distance += 30;
            setFuel(getFuel() - getFuelUse());
            if (getFuel() < getFuelUse()) {
                System.out.println("Машина проехала: " + distance + "км" + "\n");
            }
        }
        System.out.println("Топливо закончилось(");
    }

    public void statistic() {
        System.out.println("Серия: " + series + "\n" + "Год выпуска: " + year + "\n" + "Цвет: " + color + "\n" + "Количество топлива: " + fuel + "\n" + "Размер бака:" + tankSize);
    }

    public Car(int series, int year, String color, int fuel, int tankSize, int fuelUse) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
        this.tankSize = tankSize;
        this.fuelUse = fuelUse;
    }
    public int getSeries () {
        return series;
    }

    public int getYear () {
        return year;
    }

    public String getColor () {
        return color;
    }

    public int getTankSize () {
        return tankSize;
    }

    public int getFuel () {
        return fuel;
    }

    public int getFuelUse () {
        return fuelUse;
    }

    public void setFuel ( int fuel ) {
        this.fuel = fuel;
    }

    public void setFuelUse ( int fuelUse ) {
        this.fuelUse = fuelUse;
    }

    public void refuel() {
        fuel = 100;
        System.out.println("Топливо залито " + fuel);
    }
}


