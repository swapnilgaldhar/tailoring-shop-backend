package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillItemRequestDTO {

    private String itemName;

    private String itemDescription;

    private Integer quantity;

    private Double rate;

    private Double amount;

}