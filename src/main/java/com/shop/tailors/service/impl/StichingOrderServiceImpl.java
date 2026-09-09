package com.shop.tailors.service.impl;

import com.shop.tailors.dto.StichingDetailsDTO;
import com.shop.tailors.entity.StichingOrder;
import com.shop.tailors.repository.StichingOrderRepository;
import com.shop.tailors.service.StichingOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StichingOrderServiceImpl  implements StichingOrderService {

    private final StichingOrderRepository stichingOrderRepository;

    @Override
    public StichingOrder createStichingOrder(StichingOrder stichingOrder) {
     // StichingOrder savedStichingOrder = stichingOrderRepository.save(stichingOrder);

      //  String stOrderId = String.format("STI-OR-%06d", savedStichingOrder.getSrNo());
      //  savedStichingOrder.setStOrderId(stOrderId);
      //  return  stichingOrderRepository.save(savedStichingOrder);

        // First save
        StichingOrder savedOrder = stichingOrderRepository.save(stichingOrder);

        // Generate ST order ID using generated srNo
        String stOrderId =
                String.format("STI-OR-%06d", savedOrder.getSrNo());

        // Set generated order ID
        savedOrder.setStOrderId(stOrderId);

        // Save again
        return stichingOrderRepository.save(savedOrder);
    }

    @Override
    public List<StichingOrder> getAllStichingOrders() {
        return stichingOrderRepository.findAll();
    }

    @Override
    public StichingDetailsDTO getStichingOrderDetails(String billNo) {
        return stichingOrderRepository.findByBillNo(billNo);
    }

    @Override
    public void updateCurrentStage(String billNo, String currentStage) {
        StichingOrder stichingOrder = stichingOrderRepository.findByBillNumber(billNo);
        if (stichingOrder != null) {
            stichingOrder.setCurrentStage(currentStage);
            stichingOrderRepository.save(stichingOrder);
        } else {
            log.error("Stiching order not found for bill number: {}", billNo);
        }
    }
}
