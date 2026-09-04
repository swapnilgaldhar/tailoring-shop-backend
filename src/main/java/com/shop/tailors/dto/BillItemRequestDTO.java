package com.shop.tailors.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillItemRequestDTO {

    private String itemName;

    private String itemDescription;

    private Double quantity;

    private Double rate;

    private Double amount;

}