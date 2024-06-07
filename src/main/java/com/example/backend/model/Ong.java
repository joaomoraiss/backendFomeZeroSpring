package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String localizacao;
    @Column(nullable = false)
    private String tipoDeOng;

    @OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimento> necessidadesDeAlimentos = new ArrayList<>();

    public void adicionarNecessidade(Alimento alimento) {
        alimento.setOng(this);
        necessidadesDeAlimentos.add(alimento);
    }

    public void removerNecessidade(Alimento alimento) {
        necessidadesDeAlimentos.remove(alimento);
        alimento.setOng(null);
    }

    public List<String> listarNecessidades() {
        List<String> listaNecessidades = new ArrayList<>();
        for (Alimento alimento : necessidadesDeAlimentos) {
            listaNecessidades.add(alimento.getNome());
        }
        return listaNecessidades;
    }

}
