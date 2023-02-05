package com.my.demo.service;

import com.my.demo.dto.CreatePaymentDto;
import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import com.my.demo.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class PaymentCreateServiceTest {
    @Mock
    PaymentRepository paymentRepository;
    @InjectMocks
    PaymentCreateService paymentCreateService;

    @Test
    public void createPaymentShouldReturnCreatedPaymentId() {
        CreatePaymentDto dto = createPaymentDto();
        Payment expectedPayment = createPaymentToSave();

        when(paymentRepository.save(any(Payment.class))).thenReturn(expectedPayment);

        Long resultPaymentId = paymentCreateService.createPayment(dto);
        assertEquals(expectedPayment.getId(), resultPaymentId);
    }
    private Payment createPaymentToSave(){
        return Payment.builder()
                .firstName("firstName")
                .lastName("lastName")
                .patronymic("patronymic")
                .amount(120d)
                .status(PaymentStatus.NEW)
                .build();
    }

    private CreatePaymentDto createPaymentDto(){
        return CreatePaymentDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .patronymic("patronymic")
                .amount(120d)
                .build();
    }
}
