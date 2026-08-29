package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SherwaniMeasurementDTO {

    private Long measurementId;
    private Long customerId;
    private Double chest;
    private Double waist;
    private Double hip;
    private Double shoulder;
    private Double sleeve;
    private Double length;
    private Double neck;
    private Double stand;
    private Double cuff;
    private String notes;
}