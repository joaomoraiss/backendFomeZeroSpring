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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String localizacao;
    @Column(nullable = false)
    private String tipoIndustria;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Armazem> armazens = new ArrayList<>();

    public void adicionarArmazem(Armazem armazem) {
        armazem.setEmpresa(this);
        armazens.add(armazem);
    }

    // Método para remover armazém da empresa
    public void removerArmazem(Armazem armazem) {
        armazens.remove(armazem);
        armazem.setEmpresa(null);
    }
}
