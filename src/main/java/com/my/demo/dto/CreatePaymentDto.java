package com.my.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreatePaymentDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Double amount;
}
