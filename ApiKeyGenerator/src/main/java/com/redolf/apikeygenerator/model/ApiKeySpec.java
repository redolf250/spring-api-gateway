package com.redolf.apikeygenerator.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.Period;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "apiKeySpec")
public class ApiKeySpec {
    @Id
    private String id;
    private String apiKey;
    private Period validity;
    private String username;
    private String description;
    private LocalDateTime createdAt;
}
