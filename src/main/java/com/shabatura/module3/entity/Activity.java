package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "activity")

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private int id;
    private String text;

    @ManyToOne
    @JoinColumn (name = "activityType_id")
    private ActType actType;

    @ManyToOne
    @JoinColumn(name = "abonent_id")
    private Abonent abonent;

    public Activity ( String text , Abonent abonent ) {
        this.text = text;
        this.abonent = abonent;
    }
    @Override
    public String toString() {
        return "Activity{" +
                "id = '" + id + '\'' +
                ", text ='" + text + '}';
    }
}
