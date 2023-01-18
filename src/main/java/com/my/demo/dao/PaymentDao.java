package com.my.demo.dao;

import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.entity.Payment;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentDao extends CrudRepository<Payment, Long> {

    @Query("select * from payments where status='FAILED' OR status='NEW'")
    List<PaymentStatusDto> findByFailedAndNewStatus();

}
