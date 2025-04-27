package com.ui.application.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestUser {
    private String username;
    private String password;
    private String role;
}
