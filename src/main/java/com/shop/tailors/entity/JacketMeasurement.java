package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JacketMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jacketMeasurementId;

    @OneToOne
    @JoinColumn(name = "measurement_Id", nullable = false, unique = true)
    @JsonBackReference("measurement-jacket")
    private Measurement measurement;

    private Double length;

    private Double chest;

    private Double waist;

    private Double hip;

    private Double shoulder;

    private Double standCollar;

    private String notes;


}
