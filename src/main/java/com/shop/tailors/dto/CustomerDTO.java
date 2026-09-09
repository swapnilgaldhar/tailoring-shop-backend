
package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long customerId;

    private String customerName;

    private Long mobileNumber;

    private String address;

    private Double balance;

    private LocalDate createdDate;

    private LocalDate lastUpdateDate;
}

