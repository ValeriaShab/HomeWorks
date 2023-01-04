package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DevType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String typeName;
    @OneToMany (mappedBy = "devType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Device> devices;

    public DevType(String typeName) {
        this.typeName = typeName;
    }
}
