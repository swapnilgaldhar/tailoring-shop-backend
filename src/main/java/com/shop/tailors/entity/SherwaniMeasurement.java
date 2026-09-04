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

    @Column(nullable = false)
    private Double chest;

    @Column(nullable = false)
    private Double waist;

    @Column(nullable = false)
    private Double hip;

    @Column(nullable = false)
    private Double shoulder;

    @Column(nullable = false)
    private Double sleeve;

    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private Double neck;

    @Column(nullable = false)
    private Double cuff;

    @Column(nullable = false)
    private Double stand;

    private String notes;

}
