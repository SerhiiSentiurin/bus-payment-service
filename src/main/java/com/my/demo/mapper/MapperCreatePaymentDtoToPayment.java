package com.my.demo.mapper;

import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class MapperCreatePaymentDtoToPayment {
    public Payment map(CreatePaymentDto dto){
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setStatus(PaymentStatus.randomStatus(PaymentStatus.class));
        return payment;
    }
}
