package com.example.backend.repository;

import com.example.backend.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, Long> {
}
