package com.shop.tailors.service;

import com.shop.tailors.dto.LoginRequest;
import com.shop.tailors.dto.LoginResponse;


public interface AuthService {

    LoginResponse login(LoginRequest request);

}