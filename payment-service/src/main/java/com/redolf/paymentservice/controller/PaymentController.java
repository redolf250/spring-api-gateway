package com.redolf.paymentservice.controller;

import com.redolf.paymentservice.utils.PaymentUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.redolf.paymentservice.utils.PaymentUtils.*;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    @GetMapping("/payments")
    private ResponseEntity<?> getPayment(){
        return new ResponseEntity<>(getPayments(), HttpStatus.OK);
    }
}
