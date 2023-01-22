package com.shabatura.module4.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "races")
public class Race {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "horse_number")
    private int horseNumber;
    @Column(name = "amount")
    private int amount;
    @Column(name = "place")
    private int place;
    @Column(name = "number_for_a_bet")
    private int numberForABet;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RaceStatus.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", nullable = false)
    private RaceStatus raceStatus;

    public RaceStatus getRaceStatus() {
        return raceStatus;
    }

    public void setRaceStats(RaceStatus raceStatus) {
        this.raceStatus = raceStatus;
    }

    public Race(LocalDateTime date, int horseNumber, int amount, int place, int numberForABet) {
        this.date = date;
        this.horseNumber = horseNumber;
        this.amount = amount;
        this.place = place;
        this.numberForABet = numberForABet;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", date of the race=" + date +
                ", horse =" + horseNumber +
                ", how many horses was in race=" + amount +
                ", place the horse took=" + place +
                ", number for a bet=" + numberForABet +
                '}';
    }
}
