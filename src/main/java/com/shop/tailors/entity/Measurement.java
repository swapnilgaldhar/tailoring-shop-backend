package com.shop.tailors.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer measurementId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties("measurements")
    private Customer customer;

    private LocalDate measurementDate;
    
    private String notes;
    
    @OneToOne(mappedBy = "measurement",
            cascade = CascadeType.ALL)
    private PantMeasurement pantMeasurement;

    @OneToOne(mappedBy = "measurement",
            cascade = CascadeType.ALL)
    private ShirtMeasurement shirtMeasurement;

  
}
