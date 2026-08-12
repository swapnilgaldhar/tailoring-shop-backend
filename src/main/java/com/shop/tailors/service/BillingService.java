package com.shop.tailors.service;

import com.shop.tailors.dto.BillRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface BillingService {


    void createBill(BillRequestDTO billRequestDTO);

    BillRequestDTO getBillDetails(String billNumber);
}
