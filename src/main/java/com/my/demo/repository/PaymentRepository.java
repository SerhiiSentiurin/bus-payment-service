package com.my.demo.repository;

import com.my.demo.entity.Payment;
import com.my.demo.entity.PaymentStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findAllByStatus(PaymentStatus status);
}
