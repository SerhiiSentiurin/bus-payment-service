package com.my.demo.mapper;

import com.my.demo.dao.PaymentDao;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperPaymentStatusDtoToPayment {
    private final PaymentDao paymentDao;

    public List<Payment> map(List<PaymentStatusDto> dtoList){
        List<Payment> paymentList = new ArrayList<>();
        for (PaymentStatusDto dto: dtoList) {
            Payment payment = new Payment();
            payment.setId(dto.getId());
            payment.setAmount(paymentDao.findById(dto.getId()).get().getAmount());
            payment.setStatus(dto.getStatus());
            paymentList.add(payment);
        }
        return paymentList;
    }
}
