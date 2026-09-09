package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShirtMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shirtMeasurementId;

    @OneToOne
    @JoinColumn(name = "measurement_Id", nullable = false, unique = true)
    @JsonBackReference("measurement-shirt")
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

    private String notes;
}