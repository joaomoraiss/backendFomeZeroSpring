package com.example.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String gender;

    // Construtor padrão
    public Register() {
    }

    // Construtor com argumentos
    public Register(String email, String password, String nickname, String gender) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
    }

    // Getters e setters
}
