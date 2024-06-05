package com.example.backend.controller;

import com.example.backend.model.Ong;
import com.example.backend.model.Alimento;
import com.example.backend.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ongs")
public class OngController {

    @Autowired
    private OngRepository repository;

    @GetMapping
    public ResponseEntity<List<Ong>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Ong> create(@RequestBody Ong ong) {
        return ResponseEntity.ok(repository.save(ong));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ong> update(@PathVariable Long id, @RequestBody Ong ong) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ong.setId(id);
        return ResponseEntity.ok(repository.save(ong));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adicionar-necessidade")
    public ResponseEntity<Void> adicionarNecessidade(@PathVariable Long id, @RequestBody Alimento alimento) {
        Ong ong = repository.findById(id).orElse(null);
        if (ong == null) {
            return ResponseEntity.notFound().build();
        }
        ong.adicionarNecessidade(alimento);
        repository.save(ong);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/remover-necessidade")
    public ResponseEntity<Void> removerNecessidade(@PathVariable Long id, @RequestBody Alimento alimento) {
        Ong ong = repository.findById(id).orElse(null);
        if (ong == null) {
            return ResponseEntity.notFound().build();
        }
        ong.removerNecessidade(alimento);
        repository.save(ong);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/listar-necessidades")
    public ResponseEntity<List<String>> listarNecessidades(@PathVariable Long id) {
        Ong ong = repository.findById(id).orElse(null);
        if (ong == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ong.listarNecessidades());
    }

}
