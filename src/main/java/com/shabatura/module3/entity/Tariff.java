package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String nameOfTariff;
    private Double price;
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Abonent> abonents;

    public Tariff(String nameOfTariff, Double price) {
        this.nameOfTariff = nameOfTariff;
        this.price = price;
    }
}
