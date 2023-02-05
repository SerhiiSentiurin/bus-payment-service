package com.my.demo.service;

import com.my.demo.entity.PaymentStatus;
import com.my.demo.repository.PaymentRepository;
import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentCreateService {
    private final PaymentRepository paymentRepository;

    public Long createPayment(CreatePaymentDto dto) {
        Payment payment = Payment.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .patronymic(dto.getPatronymic())
                .amount(dto.getAmount())
                .status(PaymentStatus.NEW)
                .build();
        return paymentRepository.save(payment).getId();
    }

}
