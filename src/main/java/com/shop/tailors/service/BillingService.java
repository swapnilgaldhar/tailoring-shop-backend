package com.shop.tailors.service;

import com.shop.tailors.dto.BillRequestDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    BillRequestDTO createBill(BillRequestDTO billRequestDTO);

    BillRequestDTO getBillDetails(String billNumber);

    void updateDeliveryStatus(String billNumber, String status);

    List<BillRequestDTO> getAllBillsForCustomer(Long customerId);
}
