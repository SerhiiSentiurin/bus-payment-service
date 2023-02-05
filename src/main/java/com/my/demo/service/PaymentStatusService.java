package com.my.demo.service;

import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentStatusService {
    private final PaymentRepository paymentRepository;

    public PaymentStatus getStatus(Long id) {
        List<PaymentStatus> paymentStatus = Arrays.asList(PaymentStatus.values());
        Collections.shuffle(paymentStatus);
        return paymentStatus.stream().findFirst().orElse(PaymentStatus.NEW);
    }

    public void updateStatuses(List<Payment> payments) {
        paymentRepository.saveAll(payments);
    }

    public List<Payment> getPayments(PaymentStatus status){
        return paymentRepository.findAllByStatus(status);
    }
}
