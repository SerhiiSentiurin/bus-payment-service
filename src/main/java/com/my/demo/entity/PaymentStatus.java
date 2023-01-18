package com.my.demo.entity;

import java.util.Random;

public enum PaymentStatus {
    NEW, FAILED, DONE;

    public static <T extends Enum<?>> T randomStatus(Class<T> tClass){
        Random random = new Random();
        int index = random.nextInt(tClass.getEnumConstants().length);
        return tClass.getEnumConstants()[index];
    }
}
