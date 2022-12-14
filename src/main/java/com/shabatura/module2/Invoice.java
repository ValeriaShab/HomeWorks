package com.shabatura.module2;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Invoice {
    List<Goods> goods;
    Customer customer;
    String type;
    private String date;
    static int limit;


    public static String setType(String s) {
        return s;
    }

    public static String chooseInvoiceType(List<Goods> goods) {
        int amountOfCheck = goods.stream()
                .map(s -> s.getPrice())
                .mapToInt(s -> s)
                .sum();
        if (amountOfCheck >= getLimit()) {
            return "wholesale";
        } else {
            return "retail";
        }
    }

    public static int getLimit() {
        return limit;
    }

    public static void setLimit(int limit) {
        Invoice.limit = limit;
    }

    public Invoice(List<Goods> goods, Customer customer, String type, String date) {
        this.goods = goods;
        this.customer = customer;
        this.type = type;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Invoice: " + date + " " + type + " " + customer + "\n" + goods;
    }
}
