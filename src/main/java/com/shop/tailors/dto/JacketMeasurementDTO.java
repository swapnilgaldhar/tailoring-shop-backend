package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JacketMeasurementDTO {

    private Integer jacketMeasurementId;

    private Long customerId;

    private Long measurementId;

    private Double length;

    private Double chest;

    private Double waist;

    private Double hip;

    private Double shoulder;

    private Double standCollar;

    private Double note;
}
