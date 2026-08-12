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

    private Double waist;

    private Double hip;

    private Double thigh;

    private Double knee;

    private Double calf;

    private Double bottom;
    
    private Double length;

    private String notes;
}
