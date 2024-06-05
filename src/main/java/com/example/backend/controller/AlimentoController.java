package com.example.backend.controller;

import com.example.backend.model.Alimento;
import com.example.backend.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Alimento>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
        return ResponseEntity.ok(repository.save(alimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimento> update(@PathVariable UUID id, @RequestBody Alimento alimento) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alimento.setId(id);
        return ResponseEntity.ok(repository.save(alimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
