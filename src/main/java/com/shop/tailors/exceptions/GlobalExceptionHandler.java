package com.shop.tailors.exceptions;

import com.shop.tailors.dto.ErrorResponse;
import com.shop.tailors.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
      public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex){

            ErrorResponse errorResponse = new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(),
                    "Customer not found",
                    ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
      }
}
