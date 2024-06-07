package com.example.backend.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private Boolean disponibilidade;

    public void mudarDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void oferecerAjuda() {
        if (this.disponibilidade) {
            System.out.println(nome + " está oferecendo ajuda!");
        } else {
            System.out.println(nome + " não está disponível no momento.");
        }
    }
}
