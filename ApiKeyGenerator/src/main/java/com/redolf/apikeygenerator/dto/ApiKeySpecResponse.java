package com.redolf.apikeygenerator.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.Period;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeySpecResponse {
    private String apiKey;
    private Period validity;
    private LocalDateTime createdAt;
    private LocalDateTime expiresOn;
    private String description;
}
