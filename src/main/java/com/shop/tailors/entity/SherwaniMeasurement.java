package com.shop.tailors.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SherwaniMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sherwaniMeasurementId;

    @OneToOne
    @JoinColumn(name = "measurement_Id", nullable = false, unique = true)
    @JsonBackReference("measurement-sherwani")
    private Measurement measurement;

    private Double chest;

    private Double waist;

    private Double hip;

    private Double shoulder;

    private Double sleeve;

    private Double length;

    private Double neck;

    private Double cuff;

    private Double stand;

    private String notes;

}
