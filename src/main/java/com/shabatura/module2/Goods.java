package main.java.com.shabatura.module2;

import lombok.Getter;

@Getter

public class Goods {
    String series;
    String screenType;
    Integer price;

    public Goods(String series, String screenType, Integer price) {
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }
}
