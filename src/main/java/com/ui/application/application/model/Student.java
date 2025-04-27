package com.ui.application.application.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;


}
