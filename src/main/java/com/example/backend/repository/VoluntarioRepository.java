package com.example.backend.repository;
import com.example.backend.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoluntarioRepository extends JpaRepository<Voluntario, UUID> {
}
