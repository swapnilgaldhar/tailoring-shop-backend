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

    private Integer jacketMeasurementNo;

    private Integer sherwaniMeasurementNo;

    private Integer blazerMeasurementNo;

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

    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("measurement-jacket")
    private JacketMeasurement jacketMeasurement;

    @OneToOne(mappedBy = "measurement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("measurement-blazer")
    private BlazerMeasurement blazerMeasurement;

    public Integer getJacketMeasurementNo() {
        return jacketMeasurementNo;
    }

    public void setJacketMeasurementNo(Integer jacketMeasurementNo) {
        this.jacketMeasurementNo = jacketMeasurementNo;
    }

    public Integer getBlazerMeasurementNo() {
        return blazerMeasurementNo;
    }

    public void setBlazerMeasurementNo(Integer blazerMeasurementNo) {
        this.blazerMeasurementNo = blazerMeasurementNo;
    }
}
