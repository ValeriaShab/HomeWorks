package com.shabatura.hw11;

public class PassengerCar extends Car{
    private final Passenger[] passengersInCar;
    public PassengerCar(int series, int year, String color, int fuel, int tankSize, int fuelUse){
        super(series, year, color, fuel, tankSize, fuelUse);
        passengersInCar = new Passenger[3];
    }

    public void loadingPassengers(Passenger passenger) {
        for (int i = 0; i < passengersInCar.length; i++) {
            if (passengersInCar[i] == null) {
                passengersInCar[i] = passenger;
                System.out.println("Пассажир успешно сел");
                return;
            } else if(i == passengersInCar.length - 1){
                System.out.println("Свободных мест в машине нет(");
            }
        }
    }
    public void showPassengers() {
        if (passengersInCar[0] == null) {
            System.out.println("В машине нет пассажиров");
        } else {
            for (Passenger passenger : passengersInCar) {
                System.out.println(passenger);
            }
        }
    }
    public void refuel() {
        fuel = 100;
        System.out.println("Топливо залито " + fuel);
    }
}
