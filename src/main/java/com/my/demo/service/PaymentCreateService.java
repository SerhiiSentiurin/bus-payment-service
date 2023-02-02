package com.my.demo.service;

import com.my.demo.entity.PaymentStatus;
import com.my.demo.repository.PaymentRepository;
import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class PaymentCreateService {
    private final PaymentRepository paymentRepository;
    @Transactional
    public Long createPayment(CreatePaymentDto dto) {

        Payment payment = Payment.builder()
                .amount(dto.getAmount())
                .status(PaymentStatus.randomStatus())
                .build();
        return paymentRepository.save(payment).getId();
    }

}
