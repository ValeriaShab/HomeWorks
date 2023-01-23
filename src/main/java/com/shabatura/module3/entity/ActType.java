package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActType extends Activity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeName;
    @OneToMany (mappedBy = "actType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Activity> activities;

    public ActType(String typeName) {
        this.typeName = typeName;
    }

}
