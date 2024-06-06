package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    @Column(nullable = false)
    private String email;

    @Getter
    @Column(nullable = false)
    private String password;

    @Getter
    @Column(nullable = false)
    private String username;

    @Getter
    @Column(nullable = false)
    private String gender;
}
