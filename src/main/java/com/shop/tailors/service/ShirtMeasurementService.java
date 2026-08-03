package com.shop.tailors.service;

import com.shop.tailors.dto.ShirtMeasurementDTO;
import org.springframework.stereotype.Service;


public interface ShirtMeasurementService {

   ShirtMeasurementDTO saveShirtMeasurement(ShirtMeasurementDTO dto);

    ShirtMeasurementDTO getShirtMeasurement(Long customerId);
}
