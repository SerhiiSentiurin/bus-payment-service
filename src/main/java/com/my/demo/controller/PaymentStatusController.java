package com.my.demo.controller;

import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments/statuses")
@RequiredArgsConstructor
public class PaymentStatusController {
    private final PaymentStatusService paymentStatusService;

    @GetMapping("/{paymentId}")
    public PaymentStatus getStatus(@PathVariable Long paymentId) {
        return paymentStatusService.getStatus(paymentId);
    }

    @PutMapping
    public void updateStatuses(@RequestBody List<Payment> payments) {
        paymentStatusService.updateStatuses(payments);
    }

    @GetMapping
    public List<Payment> getPayments(@RequestParam PaymentStatus status) {
        return paymentStatusService.getPayments(status);
    }
}
