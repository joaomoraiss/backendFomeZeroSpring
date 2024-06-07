package com.example.backend.controller;

import com.example.backend.model.Alimento;
import com.example.backend.model.Transportadora;
import com.example.backend.repository.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraRepository repository;

    @GetMapping
    public ResponseEntity<List<Transportadora>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Transportadora> create(@RequestBody Transportadora transportadora) {
        return ResponseEntity.ok(repository.save(transportadora));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transportadora> update(@PathVariable UUID id, @RequestBody Transportadora transportadora) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        transportadora.setId(id);
        return ResponseEntity.ok(repository.save(transportadora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adicionarAlimento")
    public ResponseEntity<Transportadora> adicionarAlimento(@PathVariable UUID id, @RequestBody Alimento alimento) {
        Transportadora transportadora = repository.findById(id).orElse(null);
        if (transportadora == null) {
            return ResponseEntity.notFound().build();
        }
        transportadora.adicionarAlimento(alimento);
        return ResponseEntity.ok(repository.save(transportadora));
    }

    @PostMapping("/{id}/removerAlimento")
    public ResponseEntity<Transportadora> removerAlimento(@PathVariable UUID id, @RequestBody Alimento alimento) {
        Transportadora transportadora = repository.findById(id).orElse(null);
        if (transportadora == null) {
            return ResponseEntity.notFound().build();
        }
        transportadora.removerAlimento(alimento);
        return ResponseEntity.ok(repository.save(transportadora));
    }

    @GetMapping("/{id}/listarAlimentosTransportados")
    public ResponseEntity<List<String>> listarAlimentosTransportados(@PathVariable UUID id) {
        Transportadora transportadora = repository.findById(id).orElse(null);
        if (transportadora == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transportadora.listarAlimentosTransportados());
    }
}
