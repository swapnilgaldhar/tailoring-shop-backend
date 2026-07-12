package com.shop.tailors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class LoginResponse {

    private Integer id;
    private String username;
    private Long mobileNumber;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(Integer id, String username, Long mobileNumber, String message) {
        this.id = id;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}