package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class StichingDetailsDTO {

    private LocalDate orderDate;
    private Long customerId;
    private String customerName;
    private LocalDate deliveryDate;
    private String notes;

    public StichingDetailsDTO(LocalDate orderDate, Long customerId, String customerName, LocalDate deliveryDate, String notes) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.deliveryDate = deliveryDate;
        this.notes = notes;
    }
}
