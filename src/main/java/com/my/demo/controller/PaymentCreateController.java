package com.my.demo.controller;

import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.service.PaymentCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentCreateController {

    private final PaymentCreateService paymentCreateService;

    @PostMapping("/create")
    public Long createPayment(@RequestBody CreatePaymentDto dto) {
        return paymentCreateService.createPayment(dto);
    }
}
