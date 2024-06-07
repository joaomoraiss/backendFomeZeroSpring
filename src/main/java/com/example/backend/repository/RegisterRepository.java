package com.example.backend.repository;

import com.example.backend.model.Register;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    boolean existsByEmail(String email);
    Register findByUsername(String username);

    boolean existsById(UUID id);

    void deleteById(UUID id);
}
