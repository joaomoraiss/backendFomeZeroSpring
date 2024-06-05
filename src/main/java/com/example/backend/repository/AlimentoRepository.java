package com.example.backend.repository;

import com.example.backend.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    boolean existsById(UUID id);
}
