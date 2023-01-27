package com.my.demo.service.impl;

import com.my.demo.dao.PaymentDao;
import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.exception.PaymentNotFoundException;
import com.my.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;
    @Override
    @Transactional
    public Long createPayment(CreatePaymentDto dto) {
        Payment payment = Payment.builder()
                .amount(dto.getAmount())
                .status(PaymentStatus.randomStatus(PaymentStatus.class))
                .build();
        return paymentDao.save(payment).getId();
    }

    @Override
    public PaymentStatus getStatus(Long id) {
        Payment payment = paymentDao.findById(id).orElseThrow(() -> new PaymentNotFoundException("Payment not found!"));
        return payment.getStatus();
    }

    @Override
    public List<PaymentStatusDto> getPaymentsBadStatus() {
        return paymentDao.findByFailedAndNewStatus();
    }

    @Override
    @Transactional
    public void updateStatus(List<PaymentStatusDto> dtoList) {
        List<Long> paymantsIdList = dtoList.stream().flatMap(dto -> Stream.of(dto.getId())).collect(Collectors.toList());
        List<Payment> oldPaymentsList = (List<Payment>) paymentDao.findAllById(paymantsIdList);
        for (Payment payment : oldPaymentsList) {
            for (PaymentStatusDto dto:dtoList){
                payment.setStatus(dto.getStatus());
            }
        }
        paymentDao.saveAll(oldPaymentsList);
    }

}
