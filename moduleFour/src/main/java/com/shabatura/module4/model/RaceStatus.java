package com.shabatura.module4.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "race_status")
public class RaceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "race_id")
    private Integer raceId;

    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "winner")
    private int winner;
    @Column(name = "users_bet")
    private int numberForABet;
    @OneToMany(mappedBy = "raceStatus", cascade = CascadeType.ALL)
    private List<Race> races = new ArrayList<>();

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public RaceStatus(int winner, int numberForABet, LocalDateTime date) {
        this.winner = winner;
        this.numberForABet = numberForABet;
        this.date = date;
    }
    public RaceStatus(int raceId, int winner, int numberForABet, LocalDateTime date) {
        this.raceId = raceId;
        this.winner = winner;
        this.numberForABet = numberForABet;
        this.date = date;
    }

    @Override
    public String toString() {
        return "RaceStats{" +
                "raceId=" + raceId +
                ", date of the race=" + date +
                ", winner=" + winner +
                ", number for a bet=" + numberForABet +
                '}';
    }
}
