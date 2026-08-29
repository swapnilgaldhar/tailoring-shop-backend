package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlazerMeasurementDTO {
    private Integer blazerMeasurementId;

    private Long customerId;

    private Long measurementId;

    private Double height;

    private Double chest;

    private Double waist;

    private Double hip;

    private Double shoulder;

    private Double sleeveLength;

    private Double cuffWidth;

    private Double bicep;

    private Double lapelWidth;

    private String note;
}
