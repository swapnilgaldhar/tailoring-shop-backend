package com.shop.tailors.service;

import com.shop.tailors.dto.JacketMeasurementDTO;

public interface JacketMeasurementService {
    JacketMeasurementDTO createJacketMeasurement(JacketMeasurementDTO jacketRequest);

    JacketMeasurementDTO getJacketMeasurement(Long customerId);
}
