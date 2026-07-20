package com.shop.tailors.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="MEASUREMENTS")
public class   Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_Id")
    private Long measurementId;

    private Integer pantMeasurementNo;

    private Integer shirtMeasurementNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id", nullable = false)
    private Customer customer;

    private LocalDate createdDate;
    
    @OneToOne(mappedBy = "measurement",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private PantMeasurement pantMeasurement;

    @OneToOne(mappedBy = "measurement",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ShirtMeasurement shirtMeasurement;

  
}
