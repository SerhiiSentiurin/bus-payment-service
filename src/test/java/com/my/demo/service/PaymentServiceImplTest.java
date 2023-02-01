package com.my.demo.service;

import com.my.demo.AbstractTest;
import com.my.demo.dao.PaymentDao;
import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.exception.PaymentNotFoundException;
import com.my.demo.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PaymentServiceImplTest extends AbstractTest {
    @Mock
    PaymentDao paymentDao;
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Test
    public void createPaymentShouldReturnCreatedPaymentId() {
        CreatePaymentDto dto = createPaymentDto();
        Payment expectedPayment = new Payment(1L,dto.getAmount(),PaymentStatus.randomStatus(PaymentStatus.class));

        when(paymentDao.save(any(Payment.class))).thenReturn(expectedPayment);

        Long resultPaymentId = paymentService.createPayment(dto);
        assertEquals(expectedPayment.getId(), resultPaymentId);
    }

    @Test
    public void getStatusWhenPaymentExist() {
        Payment expectedPayment = createPayment();
        PaymentStatus expectedStatus = expectedPayment.getStatus();
        when(paymentDao.findById(expectedPayment.getId())).thenReturn(Optional.of(expectedPayment));

        PaymentStatus resultStatus = paymentService.getStatus(expectedPayment.getId());
        assertEquals(expectedStatus, resultStatus);
    }

    @Test
    public void getStatusWhenPaymentNotExistShouldThrowPaymentNotFoundException() {
        when(paymentDao.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(PaymentNotFoundException.class, () -> paymentService.getStatus(anyLong()));
    }

    @Test
    public void getPaymentsBadStatusShouldReturnListOfPaymentStatusDto(){
        List<PaymentStatusDto> expectedDtoList = createPaymentStatusDtoList();
        when(paymentDao.findByFailedAndNewStatus()).thenReturn(expectedDtoList);
        List<PaymentStatusDto> resultDtoList = paymentService.getPaymentsBadStatus();
        assertEquals(expectedDtoList,resultDtoList);
    }

    @Test
    public void getPaymentsBadStatusShouldReturnEmptyListOfPaymentStatusDto(){
        List<PaymentStatusDto> expectedDtoList = new ArrayList<>();
        when(paymentDao.findByFailedAndNewStatus()).thenReturn(expectedDtoList);
        List<PaymentStatusDto> resultDtoList = paymentService.getPaymentsBadStatus();
        assertEquals(expectedDtoList,resultDtoList);
    }

    @Test
    public void updateStatus(){
        List<PaymentStatusDto> dtoList = createPaymentStatusDtoList();
        List<Payment> paymentList = createPaymentList();
        Iterable<Long> paymentIdList = List.of(1L,2L);
        when(paymentDao.findAllById(paymentIdList)).thenReturn(paymentList);
        paymentService.updateStatus(dtoList);
        verify(paymentDao).saveAll(paymentList);
    }
}
