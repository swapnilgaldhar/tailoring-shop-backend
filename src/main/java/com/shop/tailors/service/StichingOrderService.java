package com.shop.tailors.service;

import com.shop.tailors.dto.StichingDetailsDTO;
import com.shop.tailors.entity.StichingOrder;

import java.util.List;

public interface StichingOrderService {
    StichingOrder createStichingOrder(StichingOrder stichingOrder);

    List<StichingOrder> getAllStichingOrders();

    StichingDetailsDTO getStichingOrderDetails(String billNo);

    void updateCurrentStage(String billNo, String currentStage);
}
