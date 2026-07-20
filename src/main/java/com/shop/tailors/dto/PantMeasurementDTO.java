package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PantMeasurementDTO {

    private Long measurementId;

    private Long customerId;

    private Double waist;

    private Double hip;

    private Double thigh;

    private Double knee;

    private Double calf;

    private Double bottom;

    private Double length;

    private String notes;
}
