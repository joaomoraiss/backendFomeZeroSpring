package com.example.backend.controller;

import com.example.backend.model.Login;

import com.example.backend.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Login login) {
        Login foundUser = loginRepository.findByUsername(login.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(login.getPassword())) {
            
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
