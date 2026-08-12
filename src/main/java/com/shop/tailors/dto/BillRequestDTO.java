package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BillRequestDTO {

    private Long billNumber;

    private Long customerId;

    private LocalDate billDate;

    private LocalDate deliveryDate;

    private String notes;

    private String paymentMode;

    private Double paidAmount;

    private Double discount;

    private Double totalAmount;

    private Double balanceAmount;

    private List<BillItemRequestDTO> billItems = new ArrayList<>();
}