package com.example.backend.controller;

import com.example.backend.model.Register;

import com.example.backend.repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping
    public ResponseEntity<Register> register(@RequestBody Register register) {

       
        Register newUser = registerRepository.save(register);
        return ResponseEntity.ok(newUser);
    }
}
