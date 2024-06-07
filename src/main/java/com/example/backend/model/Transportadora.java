package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private Double capacidade;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transportadora_id")
    private List<Alimento> alimentosTransportados = new ArrayList<>();

    public void adicionarAlimento(Alimento alimento) {
        alimentosTransportados.add(alimento);
    }

    public void removerAlimento(Alimento alimento) {
        alimentosTransportados.remove(alimento);
    }

    public List<String> listarAlimentosTransportados() {
        List<String> nomesAlimentos = new ArrayList<>();
        for (Alimento alimento : alimentosTransportados) {
            nomesAlimentos.add(alimento.getNome()); // Supondo que Alimento tenha um método getNome()
        }
        return nomesAlimentos;
    }
}
