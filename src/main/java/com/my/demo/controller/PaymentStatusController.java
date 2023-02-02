package com.my.demo.controller;

import com.my.demo.dto.PaymentStatusDto;
import com.my.demo.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments/statuses")
@RequiredArgsConstructor
public class PaymentStatusController {
    private final PaymentStatusService paymentStatusService;

    @GetMapping
    public String getStatus(@RequestParam Long id){
        return paymentStatusService.getStatus(id);
    }

    @GetMapping("/bad")
    public List<PaymentStatusDto> getNewAndFailedStatuses(){
        return paymentStatusService.getNewAndFailedStatuses();
    }

    @PutMapping
    public ResponseEntity<?> updateStatuses(@RequestBody List<PaymentStatusDto> paymentDtoList){
        paymentStatusService.updateStatuses(paymentDtoList);
        return ResponseEntity.ok().build();
    }

}
