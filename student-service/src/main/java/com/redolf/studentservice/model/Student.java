package com.redolf.studentservice.model;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String fullName;
    private String department;
    private String year;
}
