package com.shop.tailors.service;

import com.shop.tailors.entity.Vender;

import java.util.List;

public interface VenderService {
    void createVender(Vender vender);

    List<Vender> getAllVenders();
}
