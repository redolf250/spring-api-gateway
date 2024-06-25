package com.redolf.paymentservice.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    private String id;
    private double amount;
    private String paymentMethod;
    private LocalDateTime dateTime;
}
