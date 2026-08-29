package com.shop.tailors.service;

import com.shop.tailors.dto.BlazerMeasurementDTO;

public interface BlazerMeasurementService {
    BlazerMeasurementDTO createBlazerMeasurement(BlazerMeasurementDTO blazerRequest);

    BlazerMeasurementDTO getBlazerMeasurement(Long customerId);
}
