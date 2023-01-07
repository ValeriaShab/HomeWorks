package com.shabatura.module2;

import lombok.Getter;

@Getter

public class Television extends Goods {
    Integer diagonal;
    String country;

    public Television(String series, String screenType, Integer price, Integer diagonal, String country) {
        super(series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television( " + "series= " + series + ", screenType= " + screenType + ", price= " + price + ", diagonal= " + diagonal + ", country= " + country + ") ";
    }
}
