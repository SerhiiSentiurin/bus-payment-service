package com.my.demo.service;

import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith({MockitoExtension.class})
public class PaymentStatusServiceTest {

    @Mock
    PaymentRepository paymentRepository;

    @InjectMocks
    PaymentStatusService paymentStatusService;

    @Test
    public void updateStatusesTest(){
        List<Payment> expectedPayments = createPaymentList();
        paymentStatusService.updateStatuses(expectedPayments);
        verify(paymentRepository).saveAll(expectedPayments);
    }

    @Test
    public void getPaymentsTest(){
        List<Payment> expectedPayments = createPaymentList();
        when(paymentRepository.findAllByStatus(PaymentStatus.NEW)).thenReturn(expectedPayments);
        List<Payment> resultPayments = paymentStatusService.getPayments(PaymentStatus.NEW);
        assertEquals(expectedPayments,resultPayments);
    }

    private List<Payment> createPaymentList(){
        List<Payment> paymentList = new ArrayList<>();
        Payment payment1 = Payment.builder()
                .id(1L)
                .firstName("firstName1")
                .lastName("lastName1")
                .patronymic("patronymic1")
                .amount(120d)
                .status(PaymentStatus.NEW)
                .build();
        Payment payment2 = Payment.builder()
                .id(2L)
                .firstName("firstName2")
                .lastName("lastName2")
                .patronymic("patronymic2")
                .amount(120d)
                .status(PaymentStatus.NEW)
                .build();
        paymentList.add(payment1);
        paymentList.add(payment2);
        return paymentList;
    }
}
