package com.my.demo.service;

import com.my.demo.entity.Payment;
import com.my.demo.exception.PaymentNotFoundException;
import com.my.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentStatusService {
    private final PaymentRepository paymentRepository;

    public String getStatus(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException("Payment not found!"));
        return payment.getStatus();
    }

//    public List<PaymentStatusDto> getNewAndFailedStatuses() {
//        return paymentRepository.findByFailedAndNewStatus();
//    }
//
//    @Transactional
//    public void updateStatuses(List<PaymentStatusDto> dtoList) {
//        List<Long> paymantsIdList = dtoList.stream().flatMap(dto -> Stream.of(dto.getId())).collect(Collectors.toList());
//        List<Payment> oldPaymentsList = (List<Payment>) paymentRepository.findAllById(paymantsIdList);
//        for (Payment payment : oldPaymentsList) {
//            for (PaymentStatusDto dto:dtoList){
//                payment.setStatus(dto.getStatus());
//            }
//        }
//        paymentRepository.saveAll(oldPaymentsList);
//    }
}
