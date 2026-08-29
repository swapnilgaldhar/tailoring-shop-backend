package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDTO {
    private Long customerId;
    private String customerName;
    private Long mobileNumber;
    private String address;

    private Long billNumber;
    private LocalDate deliveryDate;
    private Double totalAmount;
    private Double paidAmount;
    private Double balanceAmount;
    private String status;
}
