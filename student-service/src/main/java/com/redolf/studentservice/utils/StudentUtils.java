package com.redolf.studentservice.utils;

import com.redolf.studentservice.model.Student;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@UtilityClass
public class StudentUtils {
    public List<Student> getStudentList(){
        Student student = Student.builder()
                .id(UUID.randomUUID().toString())
                .fullName("Asamaning Redolf")
                .department("Computer Science")
                .year("3rd")
                .build();
        Student student1 = Student.builder()
                .id(UUID.randomUUID().toString())
                .fullName("Emilia Clark")
                .department("Human Anatomy")
                .year("4th")
                .build();

        Student student2 = Student.builder()
                .id(UUID.randomUUID().toString())
                .fullName("Emily Sacky")
                .department("Biochemistry")
                .year("2nd")
                .build();
        return Stream.of(student,student1,student2).toList();
    }
}
