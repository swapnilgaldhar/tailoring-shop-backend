package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BlazerMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blazerMeasurementId;

    @OneToOne
    @JoinColumn(name = "measurement_Id", nullable = false, unique = true)
    @JsonBackReference("measurement-blazer")
    private Measurement measurement;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double chest;

    @Column(nullable = false)
    private Double waist;

    @Column(nullable = false)
    private Double hip;

    @Column(nullable = false)
    private Double shoulder;

    @Column(nullable = false)
    private Double bicep;

    @Column(nullable = false)
    private Double sleeveLength;

    private String notes;

    @Column(nullable = false)
    private Double cuffWidth;

    @Column(nullable = false)
    private Double lapelWidth;
}
