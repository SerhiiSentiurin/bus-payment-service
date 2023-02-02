package com.my.demo.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PaymentStatus {
    public static String randomStatus(){
        List<String> statuses = Arrays.asList("NEW", "FAILED", "DONE");
        Collections.shuffle(statuses);
        return statuses.stream().findFirst().orElse(null);
    }
}
