package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PantMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pantMeasurementId;

    @OneToOne
    @JoinColumn(name = "measurement_Id", nullable = false, unique = true)
    @JsonBackReference("measurement-pant")
    private Measurement measurement;

    @Column(nullable = false)
    private Double waist;

    @Column(nullable = false)
    private Double hip;

    @Column(nullable = false)
    private Double thigh;

    @Column(nullable = false)
    private Double knee;

    @Column(nullable = false)
    private Double calf;

    @Column(nullable = false)
    private Double bottom;

    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private Double chainFly;

    private String notes;
}
