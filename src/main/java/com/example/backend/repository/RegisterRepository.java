package com.example.backend.repository;

import com.example.backend.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    boolean existsByEmail(String email);
    Register findByUsername(String username);
}
