package com.my.demo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("payments")
@Data
@Builder(toBuilder = true)
public class Payment {
    @Id
    private Long id;
    private Double amount;
    private String status;
}
