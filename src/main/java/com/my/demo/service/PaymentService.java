package com.my.demo.service;

import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.PaymentStatus;

import java.util.List;

public interface PaymentService {
    Long createPayment(CreatePaymentDto dto);

    PaymentStatus getStatus(Long id);

    List<PaymentStatusDto> getPaymentsBadStatus();

    void updateStatus(List<PaymentStatusDto> dtoList);
}
