package com.shop.tailors.service;

import com.shop.tailors.dto.PantMeasurementDTO;
import com.shop.tailors.dto.ShirtMeasurementDTO;

public interface PantMeasurementService {

    PantMeasurementDTO savePantMeasurement(PantMeasurementDTO pantMeasurementDTO);

    //PantMeasurementDTO getPantMeasurement(Long customerId);
}