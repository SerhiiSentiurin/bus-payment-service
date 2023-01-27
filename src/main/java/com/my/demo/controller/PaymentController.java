package com.my.demo.controller;

import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Long createPayment(@RequestBody CreatePaymentDto dto){
        return paymentService.createPayment(dto);
    }

    @GetMapping
    public PaymentStatus getStatus(@RequestParam Long id){
        return paymentService.getStatus(id);
    }

    @GetMapping("/statuses")
    public List<PaymentStatusDto> getPaymentsBadStatus (){
        return paymentService.getPaymentsBadStatus();
    }

    @PutMapping
    public ResponseEntity<?> updateStatus(@RequestBody List<PaymentStatusDto> paymentDtoList){
        paymentService.updateStatus(paymentDtoList);
        return ResponseEntity.ok().build();
    }


}
