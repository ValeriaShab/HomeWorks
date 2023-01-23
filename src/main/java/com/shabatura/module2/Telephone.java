package com.shabatura.module2;

import lombok.Getter;

@Getter

public class Telephone extends Goods {
    String model;

    public Telephone(String series, String model, String screenType, Integer price) {
        super(series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone (" + "series= " + series + ", screenType= " + screenType + ", price= " + price + ", model= " + model + ") ";
    }
}
