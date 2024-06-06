package com.example.backend.controller;
import com.example.backend.model.Armazem;
import com.example.backend.repository.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/armazens")
public class ArmazemController {

    @Autowired
    private ArmazemRepository repository;

    @GetMapping
    public ResponseEntity<List<Armazem>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Armazem> create(@RequestBody Armazem armazem) {
        return ResponseEntity.ok(repository.save(armazem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Armazem> update(@PathVariable UUID id, @RequestBody Armazem armazem) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        armazem.setId(id);
        return ResponseEntity.ok(repository.save(armazem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
