package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "abonent")
public class Abonent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "abonent_id")
    private int abonentId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn (name = "tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn (name = "device_id")
    private Device device;

    @OneToMany (mappedBy = "abonent", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Activity> activities;

    public Abonent(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
