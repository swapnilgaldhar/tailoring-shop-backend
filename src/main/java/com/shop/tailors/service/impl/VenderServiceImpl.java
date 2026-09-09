package com.shop.tailors.service.impl;

import com.shop.tailors.entity.Vender;
import com.shop.tailors.repository.VenderRepository;
import com.shop.tailors.service.VenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VenderServiceImpl implements VenderService {

    @Autowired
    private VenderRepository venderRepository;

    @Override
    public void createVender(Vender vender) {
        // Implementation for creating a vender

        venderRepository.save(vender);
    }

    @Override
    public List<Vender> getAllVenders() {
        return venderRepository.findAll();
    }
}


