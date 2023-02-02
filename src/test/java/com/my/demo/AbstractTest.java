//package com.my.demo;
//
//import com.my.demo.dto.CreatePaymentDto;
//import com.my.demo.dto.PaymentStatusDto;
//import com.my.demo.entity.Payment;
//import com.my.demo.entity.PaymentStatus;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith({MockitoExtension.class})
//public class AbstractTest {
//
//    protected Payment createPayment(){
//        Payment payment = new Payment();
//        payment.setId(1L);
//        payment.setAmount(120d);
//        payment.setStatus(PaymentStatus.NEW);
//        return payment;
//    }
//
//    protected CreatePaymentDto createPaymentDto(){
//        CreatePaymentDto dto = new CreatePaymentDto();
//        dto.setFirstName("firstName");
//        dto.setLastName("lastName");
//        dto.setPatronymic("patronymic");
//        dto.setAmount(120d);
//        return dto;
//    }
//
//    protected List<PaymentStatusDto> createPaymentStatusDtoList(){
//        List<PaymentStatusDto> dtoList = new ArrayList<>();
//        PaymentStatusDto dto1 = new PaymentStatusDto();
//        PaymentStatusDto dto2 = new PaymentStatusDto();
//        dto1.setId(1L);
//        dto1.setStatus(PaymentStatus.NEW);
//        dto2.setId(2L);
//        dto2.setStatus(PaymentStatus.DONE);
//        dtoList.add(dto1);
//        dtoList.add(dto2);
//        return dtoList;
//    }
//
//    protected List<Payment> createPaymentList(){
//        List<Payment> paymentList = new ArrayList<>();
//        Payment payment1 = new Payment();
//        Payment payment2 = new Payment();
//        payment1.setId(1L);
//        payment1.setAmount(120d);
//        payment1.setStatus(PaymentStatus.NEW);
//        payment2.setId(2L);
//        payment2.setAmount(120d);
//        payment2.setStatus(PaymentStatus.DONE);
//        paymentList.add(payment1);
//        paymentList.add(payment2);
//        return paymentList;
//    }
//}
