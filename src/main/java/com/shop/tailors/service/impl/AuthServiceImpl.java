package com.shop.tailors.service.impl;

import org.springframework.stereotype.Service;

import com.shop.tailors.dto.LoginRequest;
import com.shop.tailors.dto.LoginResponse;
import com.shop.tailors.entity.User;

import com.shop.tailors.service.AuthService;
import com.shop.tailors.userrepo.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepo repository;

    public AuthServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = repository.findByMobileNumber(request.getMobileNumber())
                .orElseThrow(() -> new RuntimeException("Invalid Mobile Number"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getMobileNumber(),
                "Login Successful");
    }
}