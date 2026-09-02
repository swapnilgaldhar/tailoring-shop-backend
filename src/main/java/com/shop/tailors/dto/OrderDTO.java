package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long invoiceNo;

    private String orderDescription;

    private Double orderAmount;

    private Double paidAmount;

    private Double remainingAmount;

    private String paymentMethod;

    private String checkNumber;

    private LocalDate orderDate;

    private LocalDate orderRecivedDate;

    private Long venderId;

    private String venderName;
}
