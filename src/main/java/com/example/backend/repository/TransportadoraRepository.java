package com.example.backend.repository;

import com.example.backend.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportadoraRepository extends JpaRepository<Transportadora, UUID> {
}
