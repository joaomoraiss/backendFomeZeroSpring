package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FomeZeroApplication {

    public static void main(String[] args) {
        System.out.println("Iniciando a aplicação FomeZero...");
        SpringApplication.run(FomeZeroApplication.class, args);
        System.out.println("Aplicação FomeZero iniciada com sucesso!");
    }

}
