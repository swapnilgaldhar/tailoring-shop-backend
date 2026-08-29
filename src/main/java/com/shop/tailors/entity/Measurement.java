package com.shop.tailors.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "MEASUREMENTS")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_Id")
    private Long measurementId;

    private Integer pantMeasurementNo;

    private Integer shirtMeasurementNo;

    // Added the actual field here
    private Integer sherwaniMeasurementNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_Id", nullable = false)
    @JsonBackReference("customer-measurements")
    private Customer customer;

    private LocalDate createdDate;

    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("measurement-pant")
    private PantMeasurement pantMeasurement;

    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("measurement-shirt")
    private ShirtMeasurement shirtMeasurement;

    // Added the missing OneToOne relationship
    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("measurement-sherwani")
    private SherwaniMeasurement sherwaniMeasurement;
}