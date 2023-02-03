package com.my.demo.repository;

import com.my.demo.entity.Payment;
import org.springframework.data.repository.CrudRepository;


public interface PaymentRepository extends CrudRepository<Payment, Long> {

//    @Query("select * from payments where status='FAILED' OR status='NEW'")
//    List<PaymentStatusDto> findByFailedAndNewStatus();

}
