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

    private Double height;

    private Double chest;

    private Double waist;

    private Double hip;

    private Double shoulder;

    private Double bicep;

    private Double sleeveLength;

    private String note;

    private Double cuffWidth;

    private Double lapelWidth;
}
