package com.ui.application.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestStudent {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
