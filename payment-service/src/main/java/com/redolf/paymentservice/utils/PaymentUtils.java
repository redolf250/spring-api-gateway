package com.redolf.paymentservice.utils;

import com.redolf.paymentservice.model.Payments;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@UtilityClass
public class PaymentUtils {
    public List<Payments> getPayments(){
        Payments payment = Payments.builder()
                .id(UUID.randomUUID().toString())
                .paymentMethod("Cash")
                .amount(5000)
                .dateTime(LocalDateTime.now())
                .build();
        Payments payment1 = Payments.builder()
                .id(UUID.randomUUID().toString())
                .paymentMethod("Momo")
                .amount(1000)
                .dateTime(LocalDateTime.now())
                .build();
        Payments payment2 = Payments.builder()
                .id(UUID.randomUUID().toString())
                .paymentMethod("Bank")
                .amount(10000)
                .dateTime(LocalDateTime.now())
                .build();
        return Stream.of(payment,payment1,payment2).toList();
    }
}
