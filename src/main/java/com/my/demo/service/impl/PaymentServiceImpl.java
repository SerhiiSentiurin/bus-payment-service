package com.my.demo.service.impl;

import com.my.demo.dao.PaymentDao;
import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.exception.PaymentNotFoundException;
import com.my.demo.mapper.MapperCreatePaymentDtoToPayment;
import com.my.demo.mapper.MapperPaymentStatusDtoToPayment;
import com.my.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;
    private final MapperCreatePaymentDtoToPayment mapperCreatePaymentDtoToPayment;
    private final MapperPaymentStatusDtoToPayment mapperPaymentStatusDtoToPayment;

    @Override
    @Transactional
    public Long createPayment(CreatePaymentDto dto) {
        Payment payment = mapperCreatePaymentDtoToPayment.map(dto);
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
        List<Payment> paymentList = mapperPaymentStatusDtoToPayment.map(dtoList);
        paymentDao.saveAll(paymentList);
    }

}
