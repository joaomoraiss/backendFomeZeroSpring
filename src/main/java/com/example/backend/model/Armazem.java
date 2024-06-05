package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Data
@Entity
public class Armazem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private double capacidade;

    @OneToMany(mappedBy = "armazem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimento> alimentos;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public void adicionarAlimento(Alimento alimento) {
        alimento.setArmazem(this);
        alimentos.add(alimento);
    }

    public void removerAlimento(Alimento alimento) {
        alimentos.remove(alimento);
        alimento.setArmazem(null);
    }

    public List<Alimento> listarAlimentosTransportados() {
        return new ArrayList<Alimento>(alimentos);
    }


}
