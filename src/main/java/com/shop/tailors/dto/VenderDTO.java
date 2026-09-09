package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VenderDTO {

    private Long venderId;

    private String venderName;

    private String venderAddress;

    private String venderPhone;

    private Long orderId;
}