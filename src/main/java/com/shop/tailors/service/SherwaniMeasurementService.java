package com.shop.tailors.service;

import com.shop.tailors.dto.SherwaniMeasurementDTO;

public interface SherwaniMeasurementService {

    SherwaniMeasurementDTO createSherwaniMeasurement(SherwaniMeasurementDTO sherwaniRequest);

    SherwaniMeasurementDTO getSherwaniMeasurement(Long customerId);
}
