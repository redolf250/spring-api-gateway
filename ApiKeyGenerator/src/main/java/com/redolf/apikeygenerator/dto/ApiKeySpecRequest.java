package com.redolf.apikeygenerator.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeySpecRequest {
    private int validity;
    private String username;
    private String description;
}
