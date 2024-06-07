package com.example.backend.controller;

import com.example.backend.model.Register;
import com.example.backend.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    

    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping
    public ResponseEntity<List<Register>> getAll() {
        return ResponseEntity.ok(registerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Register> create(@RequestBody Register register) {
        return ResponseEntity.ok(registerRepository.save(register));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Register> update(@PathVariable Long id, @RequestBody Register register) {
        if (!registerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        register.setId(id);
        return ResponseEntity.ok(registerRepository.save(register));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!registerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        registerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
