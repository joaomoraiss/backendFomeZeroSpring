package com.example.backend.repository;

import com.example.backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByUsername(String username);
}
