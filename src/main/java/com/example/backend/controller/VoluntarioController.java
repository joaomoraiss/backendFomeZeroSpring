package com.example.backend.controller;
import com.example.backend.model.Voluntario;
import com.example.backend.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Voluntario>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Voluntario> create(@RequestBody Voluntario voluntario) {
        return ResponseEntity.ok(repository.save(voluntario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> update(@PathVariable UUID id, @RequestBody Voluntario voluntario) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        voluntario.setId(id);
        return ResponseEntity.ok(repository.save(voluntario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/mudarDisponibilidade")
    public ResponseEntity<Voluntario> mudarDisponibilidade(@PathVariable UUID id, @RequestParam Boolean disponibilidade) {
        Voluntario voluntario = repository.findById(id).orElse(null);
        if (voluntario == null) {
            return ResponseEntity.notFound().build();
        }
        voluntario.mudarDisponibilidade(disponibilidade);
        return ResponseEntity.ok(repository.save(voluntario));
    }

    @PostMapping("/{id}/oferecerAjuda")
    public ResponseEntity<Void> oferecerAjuda(@PathVariable UUID id) {
        Voluntario voluntario = repository.findById(id).orElse(null);
        if (voluntario == null) {
            return ResponseEntity.notFound().build();
        }
        voluntario.oferecerAjuda();
        return ResponseEntity.noContent().build();
    }
}
