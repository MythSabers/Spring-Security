package com.ui.application.application.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Authorities {
    @Id
    @SequenceGenerator(name = "authorities_id_sequence", sequenceName = "authorities_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_id_sequence")
    private Integer id;
    private String username;
    private String role;
}
