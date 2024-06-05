package com.example.backend.repository;

import com.example.backend.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmazemRepository extends JpaRepository<Armazem, Long> {
    boolean existsById(UUID id);
}
