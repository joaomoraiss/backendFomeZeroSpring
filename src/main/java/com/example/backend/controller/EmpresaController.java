package com.example.backend.controller;

import com.example.backend.model.Empresa;
import com.example.backend.model.Armazem;
import com.example.backend.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(repository.save(empresa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresa.setId(id);
        return ResponseEntity.ok(repository.save(empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adicionar-armazem")
    public ResponseEntity<Void> adicionarArmazem(@PathVariable Long id, @RequestBody Armazem armazem) {
        Empresa empresa = repository.findById(id).orElse(null);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        empresa.adicionarArmazem(armazem);
        repository.save(empresa);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/remover-armazem")
    public ResponseEntity<Void> removerArmazem(@PathVariable Long id, @RequestBody Armazem armazem) {
        Empresa empresa = repository.findById(id).orElse(null);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }
        empresa.removerArmazem(armazem);
        repository.save(empresa);
        return ResponseEntity.ok().build();
    }
}
