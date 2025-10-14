package com.example.demo.repository;

import com.example.demo.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    boolean existsByCodigo(String codigo);
}
