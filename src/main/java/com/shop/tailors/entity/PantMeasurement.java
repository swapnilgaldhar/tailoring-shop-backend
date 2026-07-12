package com.shop.tailors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PantMeasurement {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="measurement_id")
    private Measurement measurement;

    private Double waist;

    private Double hip;

    private Double thigh;///

    private Double knee;
    
    private Double calf; //potari

    private Double bottom;
    
    private Double length;//
}
