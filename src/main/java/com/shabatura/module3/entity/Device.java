package com.shabatura.module3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String modelName;
    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Abonent> abonents;
    @ManyToOne
    @JoinColumn (name = "deviceType_id")
    private DevType devType;

    public Device(String modelName) {
        this.modelName = modelName;
    }
    @Override
    public String toString() {
        return "Device{" +
                "model='" + modelName + '\'' + '}';
    }
}
