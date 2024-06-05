package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Column(nullable = false)
    private String nome;

    @Getter
    @Column(nullable = false)
    private String tipo;

    @Getter
    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "armazem_id", nullable = false)
    private Armazem armazem;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;

}
